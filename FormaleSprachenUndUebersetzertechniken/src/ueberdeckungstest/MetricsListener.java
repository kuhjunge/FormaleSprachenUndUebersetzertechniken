package ueberdeckungstest;

import java.util.LinkedList;
import java.util.List;

import kontrollflussgraphen.grammatik.*;

public class MetricsListener extends CymbolBaseListener {
	/**
	 * Gibt den Wert f�r die McCabe-Komplexit�t an
	 */
	private int mcCabeValue = 0;

	/**
	 * Gibt den Wert f�r die Interior-Pfad�berdeckung an
	 * 
	 * @param ctx
	 */
	private int interiorValue = 1;

	private List<Integer> stack = new LinkedList<>();
	private boolean addiere = false;

	/*
	 * f�r jede Funktion
	 */
	@Override
	public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {

		System.out.println("Metriken f�r " + ctx.getChild(1).getText());
		this.mcCabeValue = 1;
		this.interiorValue = 1;
	}

	@Override
	public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
		System.out.println("McCabe-Komplexit�t: " + this.mcCabeValue);
		System.out.println("Interior-Pfad-�berdeckung: " + this.interiorValue + "\n");
	}

	/*
	 * z�hle die Anzahl der if-Vorkommen f�r McCabe und
	 * 
	 */
	@Override
	public void enterIfstat(CymbolParser.IfstatContext ctx) {
		this.mcCabeValue++;
		stack.add(ctx.depth());
	}

	@Override
	public void exitIfstat(CymbolParser.IfstatContext ctx) {
		stack.remove(stack.size() - 1);

		if (!stack.isEmpty()) {
			this.addiere = true;
			this.interiorValue *= 2;
		} else {
			if (this.addiere) {
				this.interiorValue++;
				this.addiere = false;
			} else {
				this.interiorValue *= 2;
			}
		}

	}

	@Override
	public void enterForstat(CymbolParser.ForstatContext ctx) {
		stack.add(ctx.depth());
	}

	@Override
	public void exitForstat(CymbolParser.ForstatContext ctx) {
		stack.remove(stack.size() - 1);

		if (!stack.isEmpty()) {
			this.addiere = true;
			this.interiorValue *= 2;
		} else {
			if (this.addiere) {
				this.interiorValue *= 2;
				this.addiere = false;
			}
		}
	}
}
