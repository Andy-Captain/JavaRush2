package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {

        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        UndoListener undoListener = view.getUndoListener();
        if (document != null) {
            document.removeUndoableEditListener(undoListener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(undoListener);
        view.update();
    }

    public void setPlainText(String text){

       resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader,document,0);
        } catch (IOException | BadLocationException e) {
           ExceptionHandler.log(e);
        }

    }

    public String getPlainText(){

        StringWriter stringWriter = new StringWriter();

        try {
            new HTMLEditorKit().write(stringWriter,document,0,document.getLength());
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);

        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
    }

    public void openDocument() {
    }

    public void saveDocument() {
    }

    public void saveDocumentAs() {
    }
}