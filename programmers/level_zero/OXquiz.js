// 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
// 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.

function OXquiz(quiz) {
  var answer = new Array(quiz.length);
  for (let i = 0; i < quiz.length; i++) {
    if (eval(quiz[i].split(" = ")[0]) === +quiz[i].split(" = ")[1]) {
      answer[i] = "O";
    }
    if (eval(quiz[i].split(" = ")[0]) !== +quiz[i].split(" = ")[1]) {
      answer[i] = "X";
    }
  }
  return answer;
}

export default { OXquiz };
