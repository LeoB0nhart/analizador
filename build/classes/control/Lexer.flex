package control;
import static control.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
if |
else |
function |
abstract |
for |
case |
catch |
const |
default |
delete |
export|
false |
final |
this |
switch |
while |
null |
return |
package |
super |
this |
true |
void |
new |
document |

while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return Asignacion;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"|" {return OR;}
"&" {return AND;}
("<"|"<="|">"|">="|"!="|"==") {lexeme==yytext(); return OperadorRelacional;}
(int|String|double|boolean|char)   {lexeme=yytext(); return TipoDeDato;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
("'"{L}+)(" "|{L})*("'") {lexeme=yytext(); return Cadena;}
("("|";"|")"|","|":"|"{"|"}") {lexeme=yytext(); return CaracterEspecial;}
(ResultSet|Connection|Statement) {lexeme==yytext(); return ClasePredefinida;}
(execute|on|getParameter|setParameter) {lexeme==yytext(); return Funcion;}
(colsole"."log) {lexeme==yytext(); return Salida;}
(Read) {lexeme==yytext(); return Entrada;}
("+""+") {lexeme==yytext(); return Incremento;}
("-""-") {lexeme==yytext(); return Decremento;}


 . {return ERROR;}
