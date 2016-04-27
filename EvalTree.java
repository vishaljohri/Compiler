
public class EvalTree extends HelloBaseVisitor<Integer>{			

	int ifid = 0;
	int loopid = 0;

	@Override
	public Integer visitConditionalStatement(HelloParser.ConditionalStatementContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("PUSH 0");
		System.out.println("STORE GLOB_COND");
		System.out.println("START IF ID"+(++ifid));
		return super.visitConditionalStatement(ctx);
	}

	@Override
	public Integer visitStart_prog(HelloParser.Start_progContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("START PROG");
		return super.visitStart_prog(ctx);
	}

	@Override
	public Integer visitEnd_prog(HelloParser.End_progContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("END PROG");
		return super.visitEnd_prog(ctx);
	}

	@Override
	public Integer visitFunctionStart(HelloParser.FunctionStartContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionStart(ctx);
	}

	@Override
	public Integer visitFunctionEnd(HelloParser.FunctionEndContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionEnd(ctx);
	}

	@Override
	public Integer visitInput(HelloParser.InputContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInput(ctx);
	}

	@Override
	public Integer visitConditionalStart(HelloParser.ConditionalStartContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("STORE GLOB_COND");
		System.out.println("JNE END_ID"+(ifid));
		return super.visitConditionalStart(ctx);
	}
	
	@Override
	public Integer visitConditionalEnd(HelloParser.ConditionalEndContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("END ID"+(ifid));
		return super.visitConditionalEnd(ctx);
	}
	
	@Override
	public Integer visitEls(HelloParser.ElsContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("START ELSE ID"+(++ifid));
		return super.visitEls(ctx);
	}

	@Override
	public Integer visitCondition(HelloParser.ConditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondition(ctx);
	}

	@Override
	public Integer visitConditionElse(HelloParser.ConditionElseContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("START ELSE-IF ID"+(++ifid));
		return super.visitConditionElse(ctx);
	}
	
	@Override
	public Integer visitLoop(HelloParser.LoopContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("START LOOP ID"+(++loopid));
		return super.visitLoop(ctx);
	}

	@Override
	public Integer visitLoopStart(HelloParser.LoopStartContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("JNE END_ID"+loopid);
		return super.visitLoopStart(ctx);
	}

	@Override
	public Integer visitLoopend(HelloParser.LoopendContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("JMP START_ID"+loopid);
		System.out.println("END ID"+loopid);
		return super.visitLoopend(ctx);
	}

	@Override
	public Integer visitExpression(HelloParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Integer visitVsc(HelloParser.VscContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVsc(ctx);
	}

	@Override
	public Integer visitAddOp(HelloParser.AddOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddOp(ctx);
	}

	@Override
	public Integer visitLoopStatement(HelloParser.LoopStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLoopStatement(ctx);
	}

	@Override
	public Integer visitVaraiableInitialization(HelloParser.VaraiableInitializationContext ctx) {
		// TODO Auto-generated method stub
		if(ctx.getChild(2).getChildCount() > 1){
			
			System.out.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
			System.out.println("PUSH "+ctx.getChild(2).getChild(2).getChild(0).getChild(0).getText());
		
			switch (ctx.getChild(2).getChild(1).getText()) {
			case "+":
					System.out.println("ADD");
					break;
			case "-":
					System.out.println("SUB");
				
				break;
			
			default:
				break;
			}
			
		}else if(ctx.getChild(2).getChild(0).getChildCount() > 1){
			System.out.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
			System.out.println("PUSH "+ctx.getChild(2).getChild(0).getChild(2).getChild(0).getText());
		
			switch (ctx.getChild(2).getChild(0).getChild(1).getText()) {
			
			case "*":
					System.out.println("MUL");
					break;
			case "/":		
					System.out.println("DIV");
				break;
			default:
				break;
			}
		}else{
			System.out.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
			
		}
		
		System.out.println("STORE "+ctx.getChild(0).getText());
		return super.visitVaraiableInitialization(ctx);
	}

	@Override
	public Integer visitStackOperation(HelloParser.StackOperationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStackOperation(ctx);
	}

	@Override
	public Integer visitStackReturnOp(HelloParser.StackReturnOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStackReturnOp(ctx);
	}

	@Override
	public Integer visitParams(HelloParser.ParamsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParams(ctx);
	}

	@Override
	public Integer visitBody(HelloParser.BodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBody(ctx);
	}

	@Override
	public Integer visitMessage(HelloParser.MessageContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMessage(ctx);
	}

	@Override
	public Integer visitPrint(HelloParser.PrintContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("PUSH "+ctx.getChild(1).getText());
		System.out.println("DISP");
		return super.visitPrint(ctx);
	}

	@Override
	public Integer visitMulOp(HelloParser.MulOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMulOp(ctx);
	}

	@Override
	public Integer visitRelationalOp(HelloParser.RelationalOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalOp(ctx);
	}

	@Override
	public Integer visitFunction(HelloParser.FunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunction(ctx);
	}

	@Override
	public Integer visitParamList(HelloParser.ParamListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParamList(ctx);
	}

	@Override
	public Integer visitStatement(HelloParser.StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatement(ctx);
	}

	@Override
	public Integer visitIntegerLiteral(HelloParser.IntegerLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntegerLiteral(ctx);
	}

	@Override
	public Integer visitTerm(HelloParser.TermContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTerm(ctx);
	}

	@Override
	public Integer visitFuncCall(HelloParser.FuncCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFuncCall(ctx);
	}

	@Override
	public Integer visitFactor(HelloParser.FactorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFactor(ctx);
	}

	@Override
	public Integer visitFormalParameter(HelloParser.FormalParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFormalParameter(ctx);
	}

	@Override
	public Integer visitParExpression(HelloParser.ParExpressionContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("PUSH "+ctx.getChild(1).getChild(0).getText());
		System.out.println("PUSH "+ctx.getChild(1).getChild(2).getText());
		
		
		
		switch (ctx.getChild(1).getChild(1).getText()) {
		case ">":
			System.out.println("GT");
			//pw.write("GT");
			break;
		case ">=":
			System.out.println("GTE");
			//pw.write("GTE");
			break;
		case "=>":
			System.out.println("GTE");
			//pw.write("GTE");
			break;
		case "<":
			System.out.println("LT");
			//pw.write("LT");
			break;
		case "<=":
			System.out.println("LTE");
			//pw.write("LTE");
			break;
		case "=<":
			System.out.println("LTE");
			//pw.write("LTE");
			break;
		case "==":
			System.out.println("EQ");
			//pw.write("EQ");
			break;
		case "!=":
			System.out.println("NEQ");
		//	pw.write("NEQ");
			break;

		default:
			System.out.println("Input -> "+ ctx.getChild(1).getChild(1).getChild(1).getText());
			//pw.write("Input -> "+ ctx.getChild(1).getChild(1).getChild(1).getText());
			break;
		}
		
		return super.visitParExpression(ctx);
	}

	@Override
	public Integer visitPrimary(HelloParser.PrimaryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimary(ctx);
	}
	
}