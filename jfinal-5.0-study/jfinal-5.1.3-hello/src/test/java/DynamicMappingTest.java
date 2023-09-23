import java.util.HashMap;
import java.util.Map;

public class DynamicMappingTest {
  protected Map<String, Action> dynamicMapping = new HashMap<String, Action>(2048, 0.5F);

  public Action getAction(String url, String[] urlPara) {
    // Look for dynamic routes
    for (Map.Entry<String, Action> entry : dynamicMapping.entrySet()) {
      String rule = entry.getKey();
      boolean matches = isMatcher(rule, url);
      if (matches) {
        return entry.getValue();
      }
    }
    return null; // No matching action found
  }

  public boolean isMatcher(String actionKey, String url) {
    String[] urlArray = url.split("/");
    int urlArrayLength = urlArray.length;

    String[] actionKeyArray = actionKey.split("/");

    if (actionKeyArray.length != urlArrayLength) {
      return false;
    }

    boolean retval = true;
    for (int i = 0; i < urlArrayLength; i++) {
      if (urlArray[i].equals(actionKeyArray[i])) {
        continue;
      } else {
        if (actionKeyArray[i].startsWith("{") && actionKeyArray[i].endsWith("}")) {
          continue;
        } else {
          return false;
        }
      }
    }
    return retval;
  }

  // Your Action class definition here
  public static class Action {
    // ...
  }

  // Test the getAction method
  public static void main(String[] args) {
    DynamicMappingTest obj = new DynamicMappingTest();
    obj.dynamicMapping.put("/hello/var/{name}/{id}", new Action());

    String url = "/hello/var/name/11";
    String[] urlPara = new String[2];

    Action action = obj.getAction(url, urlPara);

    if (action != null) {
      System.out.println("Found matching action!");
      System.out.println("URL Parameters: " + urlPara[0] + ", " + urlPara[1]);
    } else {
      System.out.println("No matching action found.");
    }
  }
}
