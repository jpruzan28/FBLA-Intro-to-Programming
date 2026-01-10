/*The health of the pet is affected by vet visits, eating, sleeping, playing, and cleaning.
* Since we're going to need another more important factor which is emotion, it'll probably run 
* around the same way only it'll have a health factor as well.
**/
package properties;

public class Health {
	//Fields
	private int totalHealth;
/*I don't think we need these?*/
	
//	private int totalHunger; 
//	private int totalRest;
//	private int totalPlay;
//	private int totalClean;
	
	//Constructors
	public Health() {
		//Out of 10 because 5 factors, each one adds 1 health if 1-4 and adds 2 health if 5-10. 
		//Maybe I can use an array to do this?
		totalHealth = 10; 
		
	}
	
	//Methods
	/*What I'm trying to do is for example first make a addHunger(int nutrients) method in the Pet class which adds
	 * the certain amount of nutrients the user chooses from the food class to a totalHunger integer (it's just called 
	 * hunger in the Pet class). Then, we take that totalHunger integer and put it in this method, which will add
	 * to totalHealth!*/
	public void addHungerToHealth(int totalHunger) { 
		if (totalHunger<=4) {
			totalHealth+=1;
		} else {
			totalHealth+=2;
		}
	}
	public void addRestToHealth(int totalRest) {
		if (totalRest<=4) {
			totalHealth+=1;
		} else {
			totalHealth+=2;
		}
	}
	public void addPlayToHealth(int totalPlay) {
		if (totalPlay<=4) {
			totalHealth+=1;
		} else {
			totalHealth+=2;
		}
	}	
	public void addCleanToHealth(int totalClean) {
		if (totalClean<=4) {
			totalHealth+=1;
		} else {
			totalHealth+=2;
		}
	}
	
	

	//getter
	public int getTotalHealth() {
		return totalHealth;
	}
}
