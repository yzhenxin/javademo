package cn.example.pattern.builder;

public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mb = new MealBuilder();
		
		Meal vgMeal = mb.prepareVegMeal();
		vgMeal.showItems();
		System.out.println(vgMeal.getCost());
		
		System.out.println("--------------------------");
		
		Meal nonMeal = mb.prepareNonVegMeal();
		nonMeal.showItems();
		System.out.println(nonMeal.getCost());
	}
}
