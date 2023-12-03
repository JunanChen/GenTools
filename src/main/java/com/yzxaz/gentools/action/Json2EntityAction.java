package com.yzxaz.gentools.action;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.yzxaz.gentools.entity.dto.req.Json2EntityReq;
import com.yzxaz.gentools.entity.dto.resp.Json2EntityResp;


/**
 * json תʵ��� action
 */
public class Json2EntityAction extends AnAction {

    /**
     * jackson
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);

        if (project == null || editor == null) {
            return;
        }

        // ��ȡ��ǰ�ļ�
        PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(editor.getDocument());
        if (psiFile == null) {
            return;
        }

        // ��ȡ��ǰ��
        PsiElement psiClass = PsiTreeUtil.getParentOfType(
                psiFile.findElementAt(editor.getCaretModel().getOffset()),
                PsiElement.class
        );

        if (psiClass == null) {
            return;
        }

        // ���� Json
        String json = Messages.showMultilineInputDialog(project, "please input json", "Json 2 Entity", null, Messages.getInformationIcon(), null);
        try {
            json = objectMapper.writeValueAsString(objectMapper.readValue(json, Object.class));
        } catch (JsonProcessingException ex) {
            Messages.showMessageDialog("��������ȷ��json", "Json 2 Entity", Messages.getErrorIcon());
            return;
        }


        // ���������
        String post = null;
        Json2EntityResp json2EntityResp = null;
        try {
            Json2EntityReq json2EntityReq = new Json2EntityReq();
            json2EntityReq.dataJson(json);
            post = HttpUtil.post("http://175.178.169.18:9527/code-generation/generate/entity/json2EntityField", objectMapper.writeValueAsString(json2EntityReq));
            json2EntityResp = objectMapper.readValue(post, Json2EntityResp.class);
        } catch (JsonProcessingException ex) {
            Messages.showMessageDialog("�ӿ��쳣", "Json 2 Entity", Messages.getErrorIcon());
            return;
        }

        // �������
        Json2EntityResp finalJson2EntityResp = json2EntityResp;
        WriteCommandAction.runWriteCommandAction(project, () -> editor.getDocument().insertString(editor.getCaretModel().getOffset(), finalJson2EntityResp.getData()));
    }

}
