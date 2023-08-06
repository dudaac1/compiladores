class Interpretador {
	int interpretador (ArvoreSintatica arv)	{
		return (calcular(arv));
	}

	int calcular (ArvoreSintatica arv) {
		if (arv instanceof Mult)
			return (calcular(((Mult) arv).arg1) * calcular(((Mult) arv).arg2));

		if (arv instanceof Soma)
			return (calcular(((Soma) arv).arg1) + calcular(((Soma) arv).arg2));

		if (arv instanceof Sub)
			return (calcular(((Sub) arv).arg1) - calcular(((Sub) arv).arg2));

		if (arv instanceof Div)
			return (calcular(((Div) arv).arg1) / calcular(((Div) arv).arg2));

		if (arv instanceof Num)
			return (((Num) arv).num);

		return 0;
	}
}
