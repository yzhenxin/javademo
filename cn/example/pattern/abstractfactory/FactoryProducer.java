package cn.example.pattern.abstractfactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if ("SHAPE".equalsIgnoreCase(choice)) {
			return new ShapeFactory();
		} else if ("COLOR".equalsIgnoreCase(choice)) {
			return new ColorFactroy();
		}
		return null;
	}
}
