function calcularFatorial(numero) {
	if (numero === 0) {
	  return 1;
	} else {
	  let resultado = 1;
	  for (let i = 1; i <= numero; i++) {
		resultado *= i;
	  }
	  return resultado;
	}
  }
  
  const numero = 5;
  const cores = calcularFatorial(numero);
  console.log(`O número de possíveis combinações com ${numero} cores é ${cores}`);