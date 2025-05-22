package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class testtt {
  private Map<String, Applicant> applicantMap = new HashMap<>();
  private Map<String, Company> companyMap = new HashMap<>();
  private Map<String, String> tempApplyMap = new HashMap<>();
  private String matchingApplicant = new String();
  private String[] answer;

  public String[] solution(String[] companies, String[] applicants) {
    answer = new String[companies.length];

    setApplicantInfo(applicants);
    setHireProcess(companies);

    while (applicantMap.size() > 0) {
      doRound();
      validateApplicant();
    }
    makeAnswer();

    return answer;
  }

  private void setApplicantInfo(String[] applicants) {
    String[] applicantInfo;
    String applicant;
    int hopeCompanySize;
    String[] hopeCompanyArray;

    for (String apply : applicants) {
      applicantInfo = apply.split(" ");

      applicant = applicantInfo[0];
      hopeCompanySize = Integer.parseInt(applicantInfo[2]);
      Queue<String> companyQueue = new LinkedList<>();

      hopeCompanyArray = applicantInfo[1].substring(0, hopeCompanySize).split("");

      for (String hopeCompany : hopeCompanyArray) {
        companyQueue.add(hopeCompany);
      }

      applicantMap.put(applicant, new Applicant(companyQueue));
    }
  }

  private void setHireProcess(String[] companies) {
    String[] companyInfo;
    String name;
    int hopeEmployeeSize;
    String applicants;

    for (int i = 0; i < companies.length; i++) {
      companyInfo = companies[i].split(" ");

      name = companyInfo[0];
      applicants = companyInfo[1];
      hopeEmployeeSize = Integer.parseInt(companyInfo[2]);

      companyMap.put(name, new Company(setApplicantsValue(applicants), hopeEmployeeSize));

      answer[i] = name;
    }
  }

  private Map<String, Integer> setApplicantsValue(String applicants) {
    Map<String, Integer> applicantsValueMap = new HashMap<>();

    for (int i = 0; i < applicants.length(); i++) {
      applicantsValueMap.put(String.valueOf(applicants.charAt(i)), applicants.length() - i);
    }

    return applicantsValueMap;
  }

  private void updateApplicantInfo() {
    Map<String, Applicant> newTempApplyMap = new HashMap<>();

    for (String applicant : applicantMap.keySet()) {
      Applicant info = applicantMap.get(applicant);
      if (info == null || info.companys.isEmpty()) continue;
      newTempApplyMap.put(applicant, info);
    }
    applicantMap = newTempApplyMap;
  }

  private void doRound() {
    for (String applicant : applicantMap.keySet()) {
      Applicant info = applicantMap.get(applicant);
      if (info == null || info.companys.isEmpty()) continue;

      String targetCompanies = info.companys.poll();

      if (matchingApplicant.contains(applicant)) continue;

      tempApplyMap.put(targetCompanies, tempApplyMap.getOrDefault(targetCompanies, "") + applicant);

      matchingApplicant += applicant;
    }
    updateApplicantInfo();
  }

  private void validateApplicant() {
    for (Map.Entry<String, String> tempApply : tempApplyMap.entrySet()) {
      String targetCompany = tempApply.getKey();

      Company company = companyMap.get(targetCompany);
      String[] applicants = tempApply.getValue().split("");
      int hopeEmployeeSize = company.hopeEmployeeSize;

      if (applicants.length <= hopeEmployeeSize) continue;

      List<Map.Entry<String, Integer>> entries = new ArrayList<>();
      for (String applicant : applicants) {
        Map<String, Integer> map = new HashMap<>();
        map.put(applicant, company.applicants.get(applicant));
        entries.addAll(map.entrySet());
      }

      entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

      if (entries.size() > hopeEmployeeSize) {
        List<Map.Entry<String, Integer>> subList = entries.subList(hopeEmployeeSize, entries.size());

        for (Map.Entry<String, Integer> e : subList) {
          String key = e.getKey();
          matchingApplicant = matchingApplicant.replace(key, "");
        }

        subList.clear();
      }

      String value = "";

      for (int i = 0; i < hopeEmployeeSize; i++) {
        value += entries.get(i).getKey();
      }

      tempApplyMap.put(targetCompany, value);
    }

    updateApplicantInfo();
  }

  private void makeAnswer() {
    for (int i = 0; i < answer.length; i++) {
      String key = answer[i];
      String value = tempApplyMap.get(key);
      char[] valueArr = new char[0];

      if (value != null) valueArr = value.toCharArray();
      Arrays.sort(valueArr);
      answer[i] +=  "_" + new String(valueArr);
    }
  }

  static class Company {
    Map<String, Integer> applicants = new HashMap<>();
    int hopeEmployeeSize;

    public Company(Map<String, Integer> applicants, int hopeEmployeeSize) {
      this.applicants = applicants;
      this.hopeEmployeeSize = hopeEmployeeSize;
    }
  }

  static class Applicant {
    Queue<String> companys;

    public Applicant(Queue<String> companys) {
      this.companys = companys;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (String company : companys) {
        sb.append(company);
      }
      return sb.toString();
    }
  }

  @Test
  public void 정답1() {
    Assertions.assertEquals("A_bf", solution(new String[]{ "A fabdec 2", "B cebdfa 2", "C ecfadb 2" }, new String[]{ "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" })[0]);
    Assertions.assertEquals("B_ce", solution(new String[]{ "A fabdec 2", "B cebdfa 2", "C ecfadb 2" }, new String[]{ "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" })[1]);
    Assertions.assertEquals("C_d", solution(new String[]{ "A fabdec 2", "B cebdfa 2", "C ecfadb 2" }, new String[]{ "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" })[2]);
  }

  @Test
  public void 정답2() {
    Assertions.assertEquals("A_ab", solution(new String[]{ "A abc 2", "B abc 1" }, new String[]{ "a AB 1", "b AB 1", "c AB 1" })[0]);
    Assertions.assertEquals("B_", solution(new String[]{ "A abc 2", "B abc 1" }, new String[]{ "a AB 1", "b AB 1", "c AB 1" })[1]);
  }

  @Test
  public void 정답3() {
    Assertions.assertEquals("G_kot", solution(new String[]{ "G zoktb 3", "Q zkotb 2" }, new String[]{ "b QG 2", "k GQ 2", "o GQ 2", "t GQ 1", "z QG 2" })[0]);
    Assertions.assertEquals("Q_bz", solution(new String[]{ "G zoktb 3", "Q zkotb 2" }, new String[]{ "b QG 2", "k GQ 2", "o GQ 2", "t GQ 1", "z QG 2" })[1]);
  }

  @Test
  public void 정답5() {
    Assertions.assertEquals("M_j", solution(new String[]{ "M mrjxt 1", "Q xrmtj 2", "W rxmjt 2" }, new String[]{ "j WMQ 3", "m WMQ 2", "r WQM 1", "t WQM 1", "x QWM 3" })[0]);
    Assertions.assertEquals("Q_x", solution(new String[]{ "M mrjxt 1", "Q xrmtj 2", "W rxmjt 2" }, new String[]{ "j WMQ 3", "m WMQ 2", "r WQM 1", "t WQM 1", "x QWM 3" })[1]);
    Assertions.assertEquals("W_mr", solution(new String[]{ "M mrjxt 1", "Q xrmtj 2", "W rxmjt 2" }, new String[]{ "j WMQ 3", "m WMQ 2", "r WQM 1", "t WQM 1", "x QWM 3" })[2]);
  }

  @Test void 정답6() {
    Assertions.assertEquals("I_au", solution(new String[]{ "I auhfc 2", "R hafcu 3" }, new String[]{ "a IR 2", "c RI 2", "f RI 1", "h RI 2", "u RI 2" })[0]);
    Assertions.assertEquals("R_cfh", solution(new String[]{ "I auhfc 2", "R hafcu 3" }, new String[]{ "a IR 2", "c RI 2", "f RI 1", "h RI 2", "u RI 2" })[1]);
  }

}