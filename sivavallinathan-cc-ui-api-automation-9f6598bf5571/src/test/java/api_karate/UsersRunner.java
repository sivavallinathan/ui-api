package api_karate;

import com.intuit.karate.junit5.Karate;

class UsersRunner {
    
    @Karate.Test
    Karate CampusCashAPI() {
        return Karate.run().relativeTo(getClass());
    }    

}
