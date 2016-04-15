
public class EvaluateVisitor extends HelloBaseVisitor<Integer>{

	@Override
	public Integer visitExpression(HelloParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Integer visitRelationalOp(HelloParser.RelationalOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalOp(ctx);
	}

	@Override
	public Integer visitBody(HelloParser.BodyContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("inside body");
		return super.visitBody(ctx);
	}

	@Override
	public Integer visitParExpression(HelloParser.ParExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParExpression(ctx);
	}

	@Override
	public Integer visitFormalParameter(HelloParser.FormalParameterContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("inside formalparameters");
		return super.visitFormalParameter(ctx);
	}

	@Override
	public Integer visitLoopStatement(HelloParser.LoopStatementContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("inside loopstatement");
		return super.visitLoopStatement(ctx);
	}

	@Override
	public Integer visitParamList(HelloParser.ParamListContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("inside paramlist");
		return super.visitParamList(ctx);
	}

	@Override
	public Integer visitFactor(HelloParser.FactorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFactor(ctx);
	}

	@Override
	public Integer visitParams(HelloParser.ParamsContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("inside params");
		return super.visitParams(ctx);
	}

	@Override
	public Integer visitType(HelloParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitType(ctx);
	}

	@Override
	public Integer visitAddOp(HelloParser.AddOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddOp(ctx);
	}

	@Override
	public Integer visitIntegerLiteral(HelloParser.IntegerLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntegerLiteral(ctx);
	}

	@Override
	public Integer visitPrint(HelloParser.PrintContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrint(ctx);
	}

	@Override
	public Integer visitFunction(HelloParser.FunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunction(ctx);
	}

	@Override
	public Integer visitVariableDeclaration(HelloParser.VariableDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableDeclaration(ctx);
	}

	@Override
	public Integer visitDigit(HelloParser.DigitContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDigit(ctx);
	}

	@Override
	public Integer visitMulOp(HelloParser.MulOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMulOp(ctx);
	}

	@Override
	public Integer visitStatement(HelloParser.StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatement(ctx);
	}

	@Override
	public Integer visitMessage(HelloParser.MessageContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMessage(ctx);
	}

	@Override
	public Integer visitConditionalStatement(HelloParser.ConditionalStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConditionalStatement(ctx);
	}

	@Override
	public Integer visitTerm(HelloParser.TermContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTerm(ctx);
	}

	@Override
	public Integer visitVsc(HelloParser.VscContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVsc(ctx);
	}

	@Override
	public Integer visitVaraiableInitialization(HelloParser.VaraiableInitializationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVaraiableInitialization(ctx);
	}

	@Override
	public Integer visitPrimary(HelloParser.PrimaryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimary(ctx);
	}

}
