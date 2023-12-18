class FoodRatings {
    HashMap<String,TreeSet<Pair>>cuisineMap;
    HashMap<String,Pair>foodMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap= new HashMap<>();
        foodMap=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            cuisineMap.put(cuisines[i],cuisineMap.getOrDefault(cuisines[i], new TreeSet<>((a,b)->
                                                                                         a.rating==b.rating?a.food.compareTo(b.food):
                                                                                          b.rating-a.rating
                                                                                         )) );
            cuisineMap.get(cuisines[i]).add(new Pair(foods[i],ratings[i]));
            foodMap.put(foods[i],new Pair(ratings[i],cuisines[i]));
            }
        // System.out.println(foodMap);
        // System.out.println(cuisineMap);
    }
    
    public void changeRating(String food, int newRating) {
        Pair arr=foodMap.get(food);
        TreeSet<Pair> s=cuisineMap.get(arr.cuisine);
        s.remove(new Pair(food,arr.rating));
        s.add(new Pair(food,newRating));
        foodMap.put(food, new Pair(newRating,arr.cuisine));
        cuisineMap.put(arr.cuisine,s);
        return;
    }
    
    public String highestRated(String cuisine) {
        TreeSet<Pair> s= cuisineMap.get(cuisine);
        
        return s.first().food;
    }
}
class Pair{
    String food,cuisine;
    int rating;
    public Pair(String food, int rating){
        this.food= food;
        this.rating= rating;
    }
    public Pair( int rating,String cuisine){
        this.cuisine= cuisine;
        this.rating= rating;
    }
    public String toString(){
        return cuisine+" "+food+" "+rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
/*
  c1->{f2,f5}, c2-> {f1,f3,f4} -> HashMap<String,TreeSet<{rating,food}>>
  f1->{c1,r}->HashMap<food,String[]> m
*/