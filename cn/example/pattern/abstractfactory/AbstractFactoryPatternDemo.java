package cn.example.pattern.abstractfactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		AbstractFactory saf = FactoryProducer.getFactory("SHAPE");
		saf.getShape("CIRCLE").draw();
		saf.getShape("RECTANGLE").draw();
		
		AbstractFactory caf = FactoryProducer.getFactory("COLOR");
		caf.getColor("BLUE").fill();
		caf.getColor("RED").fill();
	}
}
