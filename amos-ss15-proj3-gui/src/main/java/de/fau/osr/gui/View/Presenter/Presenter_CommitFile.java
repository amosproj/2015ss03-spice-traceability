package de.fau.osr.gui.View.Presenter;

import de.fau.osr.gui.Controller.Visitor;
import de.fau.osr.gui.Model.DataElements.CommitFile;
import de.fau.osr.gui.Model.DataElements.DataElement;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class Presenter_CommitFile extends Presenter{
    private CommitFile commitFile;

    public CommitFile getCommitFile() {
        return commitFile;
    }

    public void setCommitFile(CommitFile commitFile) {
        this.commitFile = commitFile;
    }
    
    public Presenter_CommitFile(CommitFile commitFile){
        setCommitFile(commitFile);
    }
    
    @Override
    public String getText(){
        return String.format("%s - %f", commitFile.newPath.toPath().getFileName().toString(), commitFile.impact);
    }
    
    public boolean isAvailable(){
        File f = new File(commitFile.newPath.getPath());
        return f.exists();
    }
    
    public Color getColor(){
        switch (commitFile.commitState) {
        case MODIFIED:
            System.out.print("modified ");
            return Color.YELLOW;
        case ADDED:
            System.out.print("added ");
            return Color.GREEN;
        case DELETED:
            System.out.print("deleted ");
            return Color.RED;
        default:
            System.out.print("komisch ");
            return Color.WHITE;
        }
    }

    @Override
    public JLabel present(JLabel defaultLabel) {
        defaultLabel.setBackground(getColor());
        defaultLabel.setText(getText());
        
        if(!isAvailable()){
            defaultLabel.setForeground(UIManager
                    .getColor("Label.disabledForeground"));
            defaultLabel.setBorder(null);
        }
        return defaultLabel;
    }
    
    @Override
    public DataElement visit(Visitor visitor){
        return visitor.toDataElement(this);
    }
}
