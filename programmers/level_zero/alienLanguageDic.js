// PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
// 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
// spell에 담긴 알파벳을 한 번씩만 모두 사용한 단어가 dic에 존재한다면 1,
// 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.

function alienLanguageDic(spell, dic) {
  let answer = 0;
  let isBelong = true;

  for (let di of dic) {
    for (let spe of spell) {
      if (di.indexOf(spe) == -1) {
        answer = 2;
        isBelong = false;
        break;
      }
    }

    if (isBelong) {
      answer = 1;
      break;
    }

    return answer;
  }
}

export default { alienLanguageDic };