package com.yzxaz.gentools.dialog;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import javax.swing.*;
import java.awt.*;

/**
 * <p>
 *
 * <p>
 *
 * @author 一只小安仔
 * @name Json2EntityDialog
 * @date 2023/12/3 12:46
 * @since 1.0.0
 */
public class Json2EntityDialog extends JDialog {
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextArea textArea1;
    private JButton submitButton;
    private JTextField classNameTextField;
    private JTextField jsonTextField;
    private JTextField anthorTextField;
    private JButton cancelButton;

    private Project project;

    private void onCancel() {
        dispose();
    }


    /**
     * 打开窗口
     */
    public void open() {
        pack();
        setTitle("Json 2 Entity");
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(WindowManager.getInstance().getFrame(this.project));
        setVisible(true);
    }
}
