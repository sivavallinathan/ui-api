package api_karate;

import com.intuit.karate.junit5.Karate;

class TagsRunner {
    
    @Karate.Test
    Karate CampusCashAPI() {
        //return Karate.run("Settlement-Config").tags("@AutomaticFailures").relativeTo(getClass());
        //return Karate.run("Stored-Value").relativeTo(getClass());
        return Karate.run("Financial-Service-Provider").tags("@settlementtypecreations").relativeTo(getClass());
    }    

}
