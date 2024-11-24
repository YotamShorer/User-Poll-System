package Poll_System.external_api;


import Poll_System.external_api.UsersSystemService;
import Poll_System.model.UserIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersSystemService {

   @Autowired
   private UsersSystemService userSystemFeignClient;

   public UserIdResponse isRegistered(Integer userId) {
      try {
         return userSystemFeignClient.isRegistered(userId);
      } catch (Exception e) {
         System.err.println("Error communicating with User System: " + e.getMessage());
         return null;
      }
   }
}
