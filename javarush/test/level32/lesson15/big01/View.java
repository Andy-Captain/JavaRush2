package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);

        } catch (InstantiationException e) {
            ExceptionHandler.log(e);

        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);

        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {

        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);

        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }


    public void selectedTabChanged() {

    }

    public boolean canUndo() {
        if (undoManager.canUndo()) {
            return true;
        }
        return false;
    }

    public boolean canRedo() {
        if (undoManager.canRedo()) {
            return true;
        }
        return false;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {

        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update(){

        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Creator JavaRush","About Program", JOptionPane.INFORMATION_MESSAGE);
    }
}
