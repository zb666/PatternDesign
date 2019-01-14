package factory;

public class CaseC implements IFactoryDesign {
    @Override
    public void matchTarget(String target, Object view) {

        IFactoryDesign iFactoryDesign = new CaseC();

        iFactoryDesign.matchTarget(target,view);

        

    }
}
