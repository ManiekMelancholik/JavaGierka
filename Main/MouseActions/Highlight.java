package Main.MouseActions;

import Main.GameWorld.IConnectable;

public class Highlight {
    HighlightAction action;
    HighlightAction revert;

    final IConnectable IC;

    public Highlight(HighlightAction A, HighlightAction R, IConnectable IC){
        action = A;
        revert = R;
        this.IC = IC;
    }

    public void highlight(){
        action.Action(IC);
    }
    public void highlightBack(){
        revert.Action(IC);
    }
}
