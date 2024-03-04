package inheritable_query_param;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static String main(String[] args) {
    String currentQueryParam = args.length > 0 && args[0] != null ? args[0] : "";
    String parentQueryParam = args.length > 1 && args[1] != null ? args[1] : "";
    boolean isInheritable = args.length > 2 && args[2] == "true" ? true : false;

    return mergeQueryParam(currentQueryParam, parentQueryParam, isInheritable);
  }

  public static String mergeQueryParam(String currentQueryParam, String parentQueryParam, boolean isInheritable) {
    LinkedHashMap<String, String> mergedMap = new LinkedHashMap<>();
    LinkedHashMap<String, String> currentQueryParamMap = new LinkedHashMap<>();

    StringTokenizer parent = new StringTokenizer(parentQueryParam, "&");
    StringTokenizer current = new StringTokenizer(currentQueryParam, "&");

    String key;
    String value;
    StringTokenizer token;

    while (parent.hasMoreTokens() && isInheritable) {
      token = new StringTokenizer(parent.nextToken(), "=");
      key = token.nextToken();
      value = token.nextToken();

      if (!mergedMap.containsKey(key))
        mergedMap.put(key, value);
    }

    while (current.hasMoreTokens()) {
      token = new StringTokenizer(current.nextToken(), "=");
      key = token.nextToken();
      value = token.nextToken();

      if (currentQueryParamMap.containsKey(key)) continue;
      currentQueryParamMap.put(key, value);

      if (!mergedMap.containsKey(key))
        mergedMap.put(key, value);

      else if (mergedMap.containsKey(key) && !value.equals(mergedMap.get(key)))
        mergedMap.merge(key, value, (oldValue, newValue) -> oldValue + "," + newValue);

      else mergedMap.putIfAbsent(key, value);
    }

    return buildQueryString(mergedMap);
  }

  private static String buildQueryString(Map<String, String> mergedMap) {
    StringBuilder mergedQueryParam = new StringBuilder();

    for (Map.Entry<String, String> entry : mergedMap.entrySet()) {
      mergedQueryParam.append(entry.getKey())
              .append("=")
              .append(entry.getValue())
              .append("&");
    }

    if (mergedQueryParam.length() > 0) {
      mergedQueryParam.deleteCharAt(mergedQueryParam.length() - 1);
    }

    return mergedQueryParam.toString();
  }

  @Test
  public void 하나가_null인_경우() {
    Assertions.assertEquals("division1=상의", main(new String[]{ "division1=상의", null, "false" }));
    Assertions.assertEquals("division1=상의", main(new String[]{ "division1=상의", null, "true" }));
    Assertions.assertEquals("division1=상의", main(new String[]{ null, "division1=상의", "true" }));
    Assertions.assertEquals("", main(new String[]{ null, "division1=상의", "false" }));
  }

  @Test
  public void 둘다_null이_아니고_겹치는_Key가_없는_경우() {
    Assertions.assertEquals("division1=상의&keywords=반팔티&ids=1,2", main(new String[]{ "keywords=반팔티&ids=1,2", "division1=상의", "true" }));
    Assertions.assertEquals("keywords=반팔티&ids=1,2", main(new String[]{ "keywords=반팔티&ids=1,2", "division1=상의", "false" }));
  }

  @Test
  public void 둘다_null이_아니고_겹치는_Key가_있는_경우() {
    Assertions.assertEquals("division1=상의&keywords=반팔티&ids=1,2", main(new String[]{"division1=상의&division1=하의&keywords=반팔티&ids=1,2", "division1=하의", "false"}));
    Assertions.assertEquals("division1=하의,상의&keywords=반팔티&ids=1,2", main(new String[]{"division1=상의&&keywords=반팔티&ids=1,2", "division1=하의", "true"}));
    Assertions.assertEquals("division1=상의&keywords=반팔티&ids=1,2", main(new String[]{"division1=상의&&keywords=반팔티&ids=1,2", "division1=상의", "true"}));
    Assertions.assertEquals("division1=상의&keywords=반팔티&ids=1,2", main(new String[]{"division1=상의&&keywords=반팔티&ids=1,2", "division1=하의", "false"}));
    Assertions.assertEquals("division1=상의&keywords=반팔티&ids=1,2", main(new String[]{"division1=상의&&keywords=반팔티&ids=1,2", "division1=상의&division1=하의", "true"}));
  }
}