package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class DinnerModel extends Observable implements IDinnerModel{

	private int guests;

	//total repository of dishes
	private static Set<Dish> dishes = new HashSet<Dish>();

	//current full menu of the current party
	private Set<Dish> fullMenu = new HashSet<Dish>();

	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){

		Dish dish1 = new Dish("French toast",Dish.STARTER,"toast.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
		Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
		Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
		Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		dishes.add(dish1);

		Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs.jpg","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
		Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
		Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
		Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
		Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
		Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
		Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
		Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		dishes.add(dish2);

		Dish dish3 = new Dish("Pudding", Dish.DESERT, "pudding.jpg", "Add in the ready made pudding paste to water, milk and let it cool. Refridgerate and serve cold");
		Ingredient dish3ing1 = new Ingredient("pudding paste", 30, "g", 2);
		Ingredient dish3ing2 = new Ingredient("milk", 150, "ml", 3);
		dish3.addIngredient(dish3ing1);
		dish3.addIngredient(dish3ing2);
		dishes.add(dish3);

		Dish dish4 = new Dish("Indian Yoghurt Dip", Dish.STARTER, "indianyoghurtdip.jpg", "Mix 1 cup Greek yogurt with 2 tablespoons each chopped cilantro and tomato, 1 tablespoon minced shallot, 1/2 teaspoon each grated ginger and garlic, and salt to taste. Serve with crackers or pita chips.");
		Ingredient dish4ing1 = new Ingredient("Greek Yoghurt", 300, "ml", 6);
		Ingredient dish4ing2 = new Ingredient("salt",0.7,"g",3);
		Ingredient dish4ing3 = new Ingredient("shallot",0.25,"",2);
		Ingredient dish4ing4 = new Ingredient("garlic",0.6,"g",3);
		dish4.addIngredient(dish4ing1);
		dish4.addIngredient(dish4ing2);
		dish4.addIngredient(dish4ing3);
		dish4.addIngredient(dish4ing4);
		dishes.add(dish4);

		Dish dish5 = new Dish("Fried Fish", Dish.MAIN, "friedfish.jpg", "Mix together the flour and the beer, then fold in the egg whites. Turn up the heat of the oil to 350 degrees F (180 degrees C). Dip the fish in the batter and fry for a few minutes with until golden brown.");
		Ingredient dish5ing1 = new Ingredient("Flour", 200, "g", 4);
		Ingredient dish5ing2 = new Ingredient("Egg",2,"",3);
		Ingredient dish5ing3 = new Ingredient("Beer",1,"can",6);
		Ingredient dish5ing4 = new Ingredient("White Fish",300,"g",30);
		dish5.addIngredient(dish5ing1);
		dish5.addIngredient(dish5ing2);
		dish5.addIngredient(dish5ing3);
		dish5.addIngredient(dish5ing4);
		dishes.add(dish5);

		Dish dish6 = new Dish("Soya Milk Pudding", Dish.DESERT, "soyamilkpudding.jpg", "Place 1 1/2 cups soy milk in medium saucepan. Sprinkle gelatin over top and let sit 5 minutes to allow gelatin to soften. Heat soy milk over medium heat, stirring, just until gelatin dissolves (do not boil soy milk). Stir in remaining 1 1/2 cups soy milk and vanilla. Sweeten to taste. Pour into serving bowls and chill until set and very cold, 3 to 4 hours.");
		Ingredient dish6ing1 = new Ingredient("Soya Milk", 400, "ml", 20);
		Ingredient dish6ing2 = new Ingredient("Gelatin",30,"g",3);
		Ingredient dish6ing3 = new Ingredient("Sugar",50,"g",3);
		Ingredient dish6ing4 = new Ingredient("Vanilla Extract",10,"ml",1);
		dish6.addIngredient(dish6ing1);
		dish6.addIngredient(dish6ing2);
		dish6.addIngredient(dish6ing3);
		dish6.addIngredient(dish6ing4);
		dishes.add(dish6);

		Dish dish7 = new Dish("Baked Tortilla Chips", Dish.STARTER, "bakedtortillachips","Preheat oven to 180 C. Cut each tortilla into 8 triangular wedges and arrange in a single layer on a baking tray.In a mister or spray bottle, combine the oil and lime juice. Mix well and spray each tortilla wedge until slightly moist. Combine the cumin, chilli powder and salt in a small bowl and sprinkle on the wedges. Bake for about 7 minutes. Rotate the tray and bake for another 8 minutes or until the wedges are crisp, but not too brown. Serve warm or room temperature with salsas, dips or guacamole.");
		Ingredient dish7ing1 = new Ingredient("flour tortillas", 200, "g", 20);
		Ingredient dish7ing2 = new Ingredient("lime juice",10,"ml",3);
		Ingredient dish7ing3 = new Ingredient("cumin",1,"teaspoon",3);
		Ingredient dish7ing4 = new Ingredient("chilli powder",1,"teaspoon",3);
		Ingredient dish7ing5 = new Ingredient("salt",1,"teaspoon",3);
		dish7.addIngredient(dish7ing1);
		dish7.addIngredient(dish7ing2);
		dish7.addIngredient(dish7ing3);
		dish7.addIngredient(dish7ing4);
		dish7.addIngredient(dish7ing5);
		dishes.add(dish7);

		Dish dish8 = new Dish("Fried Rice", Dish.MAIN, "friedrice.jpg", "Preheat a large skillet or wok to medium heat. Pour sesame oil in the bottom. Add white onion and peas and carrots and fry until tender. Slide the onion, peas and carrots to the side, and pour the beaten eggs onto the other side. Using a spatula, scramble the eggs. Once cooked, mix the eggs with the vegetable mix. Add the rice to the veggie and egg mixture. Pour the soy sauce on top. Stir and fry the rice and veggie mixture until heated through and combined. Add chopped green onions if desired.");
		Ingredient dish8ing1 = new Ingredient("Rice", 3, "cups", 25);
		Ingredient dish8ing2 = new Ingredient("Sesame Oil",2,"tablespoons",5);
		Ingredient dish8ing3 = new Ingredient("Onion",1,"",3);
		Ingredient dish8ing4 = new Ingredient("Eggs",2,"",6);
		Ingredient dish8ing5 = new Ingredient("Soya Sauce",3,"tablespoons",2);
		Ingredient dish8ing6 = new Ingredient("Peas",50,"g",5);
		Ingredient dish8ing7 = new Ingredient("Carrots",50,"g",5);
		dish8.addIngredient(dish8ing1);
		dish8.addIngredient(dish8ing2);
		dish8.addIngredient(dish8ing3);
		dish8.addIngredient(dish8ing4);
		dish8.addIngredient(dish8ing5);
		dish8.addIngredient(dish8ing6);
		dish8.addIngredient(dish8ing7);
		dishes.add(dish8);

		Dish dish9 = new Dish("Stuffed Strawberries", Dish.DESERT, "stuffedstrawberry.jpg", "Cut the tops off of the strawberries and stand upright on the cut side. Make a cut 3/4 of the way down from the tip of the strawberry towards the bottom. Beat together the cream cheese, sugar, and liqueur until smooth in a mixer or a food processor. Place into a piping bag with a star tip. Pipe into each strawberry and arrange on a serving platter.");
		Ingredient dish9ing1 = new Ingredient("Strawberries", 1, "pint", 30);
		Ingredient dish9ing2 = new Ingredient("confectioners' sugar",50,"g",3);
		Ingredient dish9ing3 = new Ingredient("Orange Flavored Liquer",2,"tablespoon",6);
		Ingredient dish9ing4 = new Ingredient("Cream Cheese",1,"package",10);
		dish9.addIngredient(dish9ing1);
		dish9.addIngredient(dish9ing2);
		dish9.addIngredient(dish9ing3);
		dish9.addIngredient(dish9ing4);
		dishes.add(dish9);

		this.guests = 1;
	}

	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(int numberOfGuests, Set<Dish> currentDishes){
		this.guests = numberOfGuests;
		while(currentDishes.iterator().hasNext()){
			dishes.add(currentDishes.iterator().next());
		}
	}

	public static Set<Dish> getAllDishes(){
		return dishes;
	}

	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}

	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient.
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}

	public int getNumberOfGuests(){
		return guests;
	}

	public void setNumberOfGuests(int numberOfGuests){
		this.guests = numberOfGuests;
		setChanged();
		notifyObservers(numberOfGuests);
	}

	/**
	 * Returns the dish that is on the menu for selected type (1 = starter, 2 = main, 3 = desert).
	 * returns null if there are no dishes on the menu for the selected type
	 */
	public Dish getSelectedDish(int type){

		for(Dish d : this.fullMenu){
			if(d.getType()==type){
				return d;
			}
		}

		return null;
		/*
		while(fullMenu.iterator().hasNext()){
			Dish currentDish = fullMenu.iterator().next();
			if(currentDish.getType()==type){
				return currentDish;
			}
		}*/
	}

	/**
	 * Returns all the dishes on the menu.
	 */
	public Set<Dish> getFullMenu(){
		return fullMenu;
	}

	public void setFullMenu(Set<Dish> newFullMenu){
		this.fullMenu = newFullMenu;
		setChanged();
		notifyObservers(newFullMenu);
	}

	/**
	 * Returns all ingredients for all the dishes on the menu.
	 */
	public Set<Ingredient> getAllIngredients(){
		Set<Ingredient> allIngredients = new HashSet<Ingredient>();

		for(Dish d:fullMenu){
			for(Ingredient i:d.getIngredients()){
				allIngredients.add(i);
			}
		}
		/*
		while(fullMenu.iterator().hasNext()){
			Set<Ingredient> currentDishIngredients = fullMenu.iterator().next().getIngredients();
			allIngredients.addAll(currentDishIngredients);
		}*/
		return allIngredients;
	}

	/**
	 * Returns the total price of the menu (all the ingredients multiplied by number of guests).
	 */
	public float getTotalMenuPrice(){
		double costOfMenu = 0;
		for(Dish d:this.fullMenu){
			costOfMenu+=d.getPrice();
		}
		return (float)costOfMenu * this.guests;
	}

	/**
	 * Adds the passed dish to the menu. If the dish of that type already exists on the menu
	 * it is removed from the menu and the new one added.
	 */
	public void addDishToMenu(Dish dish){

		for(Dish d : new ArrayList<Dish>(fullMenu)){
			if(d.getType()==dish.getType()){
				fullMenu.remove(d);
			}
		}
		fullMenu.add(dish);
		setChanged();
		notifyObservers(dish);
	}

	/**
	 * Remove dish from menu
	 */
	public void removeDishFromMenu(Dish dish){
		while(fullMenu.iterator().hasNext()){
			Dish currentDish = fullMenu.iterator().next();
			if(currentDish.getType()==dish.getType()){
				fullMenu.iterator().remove();
			}
		}
		setChanged();
		notifyObservers(dish);
	}


	public double totalCostOfMenu(){
		double costOfMenu = 0;
		for(Dish d:this.fullMenu){
			costOfMenu+=d.getPrice();
		}
		return costOfMenu;
	}
}