package de.fau.osr.gui.Controller;

import de.fau.osr.gui.Model.DataElements.*;
import de.fau.osr.gui.View.Presenter.*;

public abstract class Visitor {
    
    public Presenter toPresenter(AnnotatedLine line){
        return new Presenter_AnnotatedLine(line);
        
    }
    
    public Presenter toPresenter(Commit commit){
        return new Presenter_Commit(commit);
    }
    
    public Presenter toPresenter(CommitFile commitFile){
        return new Presenter_CommitFile(commitFile);
    }
    
    public Presenter toPresenter(Requirement requirement){
        return new Presenter_Requirement(requirement);
    }
    
    public DataElement toDataElement(Presenter_AnnotatedLine line){
        return line.getLine();
    }
    
    public DataElement toDataElement(Presenter_Commit commit){
        return commit.getCommit();
    }
    
    public DataElement toDataElement(Presenter_CommitFile commitFile){
        return commitFile.getCommitFile();
    }
    
    public DataElement toDataElement(Presenter_Requirement requirement){
        return requirement.getRequirement();
    }
}
