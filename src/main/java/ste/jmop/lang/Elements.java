package ste.jmop.lang;

public enum Elements {
 TOPLEVEL(1,""),
 IMPORT(2,"import"),
 CLASSDEF(3,"class"),
 METHODDEF(4,""),
 VARDEF(5,""),
 SKIP(6,""),
 BLOCK(7,""),
 DOLOOP(8,""),
 WHILELOOP(9,""),
 FORLOOP(10,""),
 FOREACHLOOP(11,""),
 LABELLED(12,""),
 SWITCH(13,""),
 CASE(14,""),
 SYNCHRONIZED(15,""),
 TRY(16,""),
 CATCH(17,""),
 CONDEXPR(18,""),
 IF(19,""),
 EXEC(20,""),
 BREAK(21,""),
 CONTINUE(22,""),
 RETURN(23,""),
 THROW(24,""),
 ASSERT(25,""),
 APPLY(26,""),
 NEWCLASS(27,""),
 NEWARRAY(28,""),
 PARENS(29,""),
 ASSIGN(30,""),
 TYPECAST(31,""),
 TYPETEST(32,""),
 INDEXED(33,""),
 SELECT(34,""),
 IDENT(35,""),
 LITERAL(36,""),
 TYPEIDENT(37,""),
 TYPEARRAY(38,""),
 TYPEAPPLY(39,""),
 TYPEPARAMETER(40,""),
 WILDCARD(41,"*"),
 TYPEBOUNDKIND(42,""),
 ANNOTATION(43,""),
 MODIFIERS(44,""),
 ERRONEOUS(45,""),
 POS(46,"+"),
 NEG(47,"-"),
 NOT(48,"!"),
 COMPL(49,"~"),
 PREINC(50,"++"),
 PREDEC(51,"--"),
 POSTINC(52,"++"),
 POSTDEC(53,"--"),
 NULLCHK(54,""),
 OR(55,"||"),
 AND(56,"&&"),
 BITOR(57,"|"),
 BITXOR(58,"^"),
 BITAND(59,"&"),
 EQ(60,"=="),
 NE(61,"!="),
 LT(62,"<"),
 GT(63,">"),
 LE(64,"<="),
 GE(65,">="),
 SL(66,"<<"),
 SR(67,">>"),
 USR(68,""),
 PLUS(69,"+"),
 MINUS(70,"-"),
 MUL(71,"*"),
 DIV(72,"/"),
 MOD(73,"%"),
 BITOR_ASG(74,"|="),
 BITXOR_ASG(75,"^="),
 BITAND_ASG(76,"&="),
 SL_ASG(83,"<<="),
 SR_ASG(84,">>="),
 USR_ASG(85,""),
 PLUS_ASG(86,"+="),
 MINUS_ASG(87,"-="),
 MUL_ASG(88,"*="),
 DIV_ASG(89,"/="),
 MOD_ASG(90,"%="),
 LETEXPR(91,""),
 ASGOffset(17,"");
    
    
    private final String represent;
    private final int value;
    
    Elements(int value, String represent) {
	this.represent = represent;
	this.value = value;
    }

    public String getRepresent() {
	return represent;
    }

    public int getValue() {
	return value;
    }
    
  
}
