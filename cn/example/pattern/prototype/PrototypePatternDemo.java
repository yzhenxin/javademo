package cn.example.pattern.prototype;

public class PrototypePatternDemo {
	public static void main(String[] args) {
		ShapeCache.loadCache();
		
		Shape cloneShape = ShapeCache.getShape("1");
		System.out.println(cloneShape.getType());
		
		Shape cloneShape1 = ShapeCache.getShape("2");
		System.out.println(cloneShape1.getType());
		
		Shape cloneShape2 = ShapeCache.getShape("3");
		System.out.println(cloneShape2.getType());
	}
}
