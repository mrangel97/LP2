// Interface 1
// Objetos pensados: celular, computador e televisão

// Representação

/* "Ligável":
        ligar()
		desligar()
*/

// Sintaxe em Java

interface Pluggable {
    void turnOn(int hour);    /* Nos dois métodos é usado o parâmetro hour para informar o horário que será ligado e desligado o(s) objeto(s) */
	void turnOff(int hour);   
}


// Interface 2
// Objetos pensados: livro, revista e jornal

// Representação

/* "Marcável":
        marcar()
		ler()
*/

// Sintaxe em Java

interface Markable {
    int mark(void);    // Nesse método é feito o retorno de um inteiro ao qual informa o número da página que o leitor parou de ler
	void read(int pages);  // Nesse método é usado o parâmetro pages para informar a quantidade de páginas que o leitor irá ler 
}
