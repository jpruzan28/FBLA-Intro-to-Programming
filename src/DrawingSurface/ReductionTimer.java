package DrawingSurface;

import pets.Pet;
import properties.*;
import java.util.TimerTask;

public class ReductionTimer {

    Pet pet;
    Emotion emotionC;
    private DrawingSurface drawingSurface;

    public ReductionTimer(Pet pet, DrawingSurface drawingSurface) {
        this.pet = pet;
        this.drawingSurface = drawingSurface;
        emotionC = new Emotion(pet);
    }

    public class reduceNutrition extends TimerTask {
        @Override
        public void run() {
            int current = pet.getNutrition();
            if (current > 0) {
                pet.setNutrition(current - 1);
            }
        }
    }

    public class reduceHygiene extends TimerTask {
        @Override
        public void run() {
            int current = pet.getHygiene();
            if (current > 0) {
                pet.setHygiene(current - 1);
            }
        }
    }

    public class reduceEmotion extends TimerTask {
        @Override
        public void run() {
            int current = pet.getEmotion();
            if (current > 0) {
                pet.setEmotion(current - 1);
            }
            emotionC.calculatingEmotion();
        }
    }

    public class reduceRest extends TimerTask {
        @Override
        public void run() {
            int current = pet.getRest();
            if (current > 0) {
                pet.setRest(current - 1);
            }
        }
    }


    // This is the ONE place health gets updated
    public class updateHealth extends TimerTask {
        @Override
        public void run() {
            Health petHealth = new Health(pet);
            petHealth.addNutritionToHealth(pet.getNutrition());
            petHealth.addRestToHealth(pet.getRest());
            petHealth.addHygieneToHealth(pet.getHygiene());
            petHealth.remindVetVisit();
        }
    }
}