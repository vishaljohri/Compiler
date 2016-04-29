import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


public class EvalTree extends TinyPyCBaseVisitor<Integer>{			

	int id = 0;
	Stack ids = new Stack<Integer>();
	FileWriter fw;
	PrintWriter pw;
	File file = new File("Intermediate.bpc");
	
	public EvalTree() throws IOException {
		// TODO Auto-generated constructor stub
		file.createNewFile();
		fw = new FileWriter(file.getAbsoluteFile());
		pw = new PrintWriter(fw);
	}
	
	@Override
	public Integer visitConditionalStatement(TinyPyCParser.ConditionalStatementContext ctx) {
		pw.println("PUSH 0");
		pw.println("STORE GLOB_COND");
		++id;
		ids.push(id);
		pw.println("START IF ID"+(id));
		return super.visitConditionalStatement(ctx);
	}

	@Override
	public Integer visitStart_prog(TinyPyCParser.Start_progContext ctx) {
		pw.println("START PROG");
		return super.visitStart_prog(ctx);
	}

	@Override
	public Integer visitEnd_prog(TinyPyCParser.End_progContext ctx) {
		pw.println("END PROG");
		pw.flush();
		return super.visitEnd_prog(ctx);
	}

	@Override
	public Integer visitFunctionStart(TinyPyCParser.FunctionStartContext ctx) {
		pw.println("PARAMOVER");
		// TODO Auto-generated method stub
		return super.visitFunctionStart(ctx);
	}

	@Override
	public Integer visitFunctionEnd(TinyPyCParser.FunctionEndContext ctx) {
		pw.println("END "+ctx.getParent().getParent().getChild(1).getText());
		return super.visitFunctionEnd(ctx);
	}

	@Override
	public Integer visitInput(TinyPyCParser.InputContext ctx) {
		pw.println("ASK");
		pw.println("STORE "+ctx.getChild(1).getText());
		
		
		return super.visitInput(ctx);
	}

	@Override
	public Integer visitConditionalStart(TinyPyCParser.ConditionalStartContext ctx) {
		pw.println("STORE GLOB_COND");
		pw.println("JNE END_ID"+(id));
		
		return super.visitConditionalStart(ctx);
	}
	
	@Override
	public Integer visitConditionalEnd(TinyPyCParser.ConditionalEndContext ctx) {
		pw.println("END ID"+(ids.pop()));
		return super.visitConditionalEnd(ctx);
	}
	
	@Override
	public Integer visitEls(TinyPyCParser.ElsContext ctx) {
		// TODO Auto-generated method stub
		id++;
		ids.push(id);
		pw.println("START ELSE ID"+(ids.peek()));
		return super.visitEls(ctx);
	}

	@Override
	public Integer visitCondition(TinyPyCParser.ConditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondition(ctx);
	}

	@Override
	public Integer visitConditionElse(TinyPyCParser.ConditionElseContext ctx) {
		// TODO Auto-generated method stub
		id++;
		ids.push(id);
		pw.println("START ELSE-IF ID"+(ids.peek()));
		return super.visitConditionElse(ctx);
	}
	
	@Override
	public Integer visitLoop(TinyPyCParser.LoopContext ctx) {
		// TODO Auto-generated method stub
		++id;
		ids.push(id);
		pw.println("START LOOP ID"+(ids.peek()));
		return super.visitLoop(ctx);
	}

	@Override
	public Integer visitLoopStart(TinyPyCParser.LoopStartContext ctx) {
		pw.println("JNE END_ID"+ids.peek());
		return super.visitLoopStart(ctx);
	}

	@Override
	public Integer visitLoopend(TinyPyCParser.LoopendContext ctx) {
		// TODO Auto-generated method stub
		
		pw.println("JMP START_ID"+ids.peek());
		pw.println("END ID"+ids.pop());
		return super.visitLoopend(ctx);
	}

	@Override
	public Integer visitExpression(TinyPyCParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Integer visitVsc(TinyPyCParser.VscContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVsc(ctx);
	}

	@Override
	public Integer visitAddOp(TinyPyCParser.AddOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddOp(ctx);
	}

	@Override
	public Integer visitLoopStatement(TinyPyCParser.LoopStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLoopStatement(ctx);
	}

	@Override
	public Integer visitVaraiableInitialization(TinyPyCParser.VaraiableInitializationContext ctx) {
		// TODO Auto-generated method stub
		
		if(ctx.getChild(2).getChildCount() > 1){
//				pw.println(ctx.getChild(2).getText());
			if(ctx.getChild(2).getText().contains("pop") || ctx.getChild(2).getText().contains("peek")){
				
			}else if(ctx.getChild(2).getText().contains("+") || ctx.getChild(2).getText().contains("-")){
				pw.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
				pw.println("PUSH "+ctx.getChild(2).getChild(2).getChild(0).getChild(0).getText());
			
				switch (ctx.getChild(2).getChild(1).getText()) {
				case "+":
						pw.println("ADD");
						break;
				case "-":
						pw.println("SUB");
					
					break;
				
				default:
					break;
				}
				pw.println("STORE "+ctx.getChild(0).getText());
				
			}
			
			
		}else if(ctx.getChild(2).getChild(0).getChildCount() > 1){
			pw.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
			pw.println("PUSH "+ctx.getChild(2).getChild(0).getChild(2).getChild(0).getText());
		
			switch (ctx.getChild(2).getChild(0).getChild(1).getText()) {
			
			case "*":
					pw.println("MUL");
					break;
			case "/":		
					pw.println("DIV");
				break;
			default:
				break;
			}
			pw.println("STORE "+ctx.getChild(0).getText());
		}else{
			
			if(ctx.getChild(2).getChild(0).getChild(0).getText().contains(":")){
				String a[] = ctx.getChild(2).getChild(0).getChild(0).getText().split(":");
				pw.println("PUSH GLOB "+a[1]);
			}else{
				pw.println("PUSH "+ctx.getChild(2).getChild(0).getChild(0).getText());
				
			}
			
			
			
			if(ctx.getChild(0).getText().contains(":")){
				String a[] = ctx.getChild(0).getText().split(":");
				pw.println("STORE GLOB "+a[1]);
			}else{
				pw.println("STORE "+ctx.getChild(0).getText());
			}
			
		}
		
		
		return super.visitVaraiableInitialization(ctx);
	}

	@Override
	public Integer visitStackOperation(TinyPyCParser.StackOperationContext ctx) {
		if(ctx.getChild(4) != null){
			if(ctx.getChild(4).getChildCount() != 0){
				
				pw.println("PUSH "+ctx.getChild(4).getChild(0).getText());
				pw.println("STORE STACK "+ctx.getChild(0).getText());
			}else if(ctx.getChild(4).getChildCount() == 0){
				pw.println("PUSH "+ctx.getChild(4).getText());
				pw.println("STORE STACK "+ctx.getChild(0).getText());
			}
		}
		
		
		
		return super.visitStackOperation(ctx);
	}

	@Override
	public Integer visitStackReturnOp(TinyPyCParser.StackReturnOpContext ctx) {
		if(ctx.getChild(2).getText().equals("pop")){
			
			if(ctx.getParent().getChildCount() == 1){
				pw.println("POP STACK "+ctx.getChild(0).getText());
			}else{
				pw.println("POP STACK "+ctx.getChild(0).getText());
				pw.println("STORE "+ctx.getParent().getChild(0).getText());
			}			
		}else{
			pw.println("PEEK STACK "+ctx.getChild(0).getText());
			pw.println("STORE "+ctx.getParent().getChild(0).getText());
		}
		
		
		return super.visitStackReturnOp(ctx);
	}
	
	

	

	@Override
	public Integer visitParams(TinyPyCParser.ParamsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParams(ctx);
	}

	@Override
	public Integer visitBody(TinyPyCParser.BodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBody(ctx);
	}

	@Override
	public Integer visitMessage(TinyPyCParser.MessageContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMessage(ctx);
	}

	@Override
	public Integer visitPrint(TinyPyCParser.PrintContext ctx) {
		if(ctx.getChild(1).getChildCount() > 1){
			String x = "";
			for(int i=1;i<ctx.getChild(1).getChildCount()-1 ;i++){
					if(i == ctx.getChild(1).getChildCount()-2){
						x += ctx.getChild(1).getChild(i).getText();
					}else{
						x += ctx.getChild(1).getChild(i).getText() + " ";
						
					}
			}
			pw.println("PUSH \""+x+"\"");
			pw.println("DISP");
			
		}else if(ctx.getChild(1).getText().contains(":")){
			String a[] = ctx.getChild(1).getText().split(":");
			pw.println("PUSH GLOB "+a[1]);
			pw.println("DISP");
		}else{
			pw.println("PUSH "+ctx.getChild(1).getText());
			pw.println("DISP");
			
		}
		
		return super.visitPrint(ctx);
	}

	@Override
	public Integer visitMulOp(TinyPyCParser.MulOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMulOp(ctx);
	}

	@Override
	public Integer visitRelationalOp(TinyPyCParser.RelationalOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalOp(ctx);
	}

	@Override
	public Integer visitFunction(TinyPyCParser.FunctionContext ctx) {
		pw.println("START FUNC "+ctx.getChild(1).getText());
		return super.visitFunction(ctx);
	}

	

	@Override
	public Integer visitStatement(TinyPyCParser.StatementContext ctx) {
		// TODO Auto-generated method stub
//		if(){
//			
//		}
		return super.visitStatement(ctx);
	}

	@Override
	public Integer visitIntegerLiteral(TinyPyCParser.IntegerLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntegerLiteral(ctx);
	}

	@Override
	public Integer visitTerm(TinyPyCParser.TermContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTerm(ctx);
	}

	@Override
	public Integer visitFuncCall(TinyPyCParser.FuncCallContext ctx) {
		// TODO Auto-generated method stub
		
		if(ctx.getChild(1).getChildCount() == 2){
			pw.println("CALL "+ctx.getChild(0).getText());
			if(ctx.getParent().getText().contains("=")){
				pw.println("STORE "+ctx.getParent().getChild(0).getText());
			}
			
		}
			
		
		return super.visitFuncCall(ctx);
	}

	@Override
	public Integer visitFactor(TinyPyCParser.FactorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFactor(ctx);
	}
	
	@Override
	public Integer visitFormalParameterCall(TinyPyCParser.FormalParameterCallContext ctx) {
		
		return super.visitFormalParameterCall(ctx);
	}
	
	@Override
	public Integer visitParamListCall(TinyPyCParser.ParamListCallContext ctx) {
		// TODO Auto-generated method stub
			
		if(ctx.getChildCount()>1){
			String a[] = ctx.getText().split(",");
			String x="";
			for(int i=0;i<a.length;i++){
				if(a[i].contains(":")){
					String b[] = a[i].split(":");
					x += " GLOB "+ b[1];
				}else{
					x += " "+ a[i];
				}
				
			}
			pw.println("CALL "+ctx.getParent().getParent().getChild(0).getText()+x);
			
		}else if(ctx.getChildCount()==1){
			if(ctx.getChild(0).getChild(0).getText().contains(":")){
				String b[] = ctx.getChild(0).getChild(0).getText().split(":");
				pw.println("CALL "+ctx.getParent().getParent().getChild(0).getText()+ " GLOB "+ b[1]);
			}else{
				pw.println("CALL "+ctx.getParent().getParent().getChild(0).getText()+ " "+ctx.getChild(0).getChild(0).getText());
			}
		}
		
		if(ctx.getParent().getParent().getParent().getText().contains("=")){
			pw.println("STORE "+ctx.getParent().getParent().getParent().getChild(0).getText());
		}
		
		return super.visitParamListCall(ctx);
	}

	@Override
	public Integer visitParamList(TinyPyCParser.ParamListContext ctx) {
		// TODO Auto-generated method stub
		
		
		return super.visitParamList(ctx);
	}
	
	@Override
	public Integer visitFormalParameter(TinyPyCParser.FormalParameterContext ctx) {
		// TODO Auto-generated method stub
		for(int i=0;i<ctx.getChildCount();i++){
				pw.println("STORE "+ctx.getChild(i).getText());
			}
		return super.visitFormalParameter(ctx);
	}

	@Override
	public Integer visitParExpression(TinyPyCParser.ParExpressionContext ctx) {
		pw.println("PUSH "+ctx.getChild(1).getChild(0).getText());
		pw.println("PUSH "+ctx.getChild(1).getChild(2).getText());
		
		switch (ctx.getChild(1).getChild(1).getText()) {
		case ">":
			pw.println("GT");
			//pw.write("GT");
			break;
		case ">=":
			pw.println("GTE");
			//pw.write("GTE");
			break;
		case "=>":
			pw.println("GTE");
			//pw.write("GTE");
			break;
		case "<":
			pw.println("LT");
			//pw.write("LT");
			break;
		case "<=":
			pw.println("LTE");
			//pw.write("LTE");
			break;
		case "=<":
			pw.println("LTE");
			//pw.write("LTE");
			break;
		case "==":
			pw.println("EQ");
			//pw.write("EQ");
			break;
		case "!=":
			pw.println("NEQ");
		//	pw.write("NEQ");
			break;

		default:
			pw.println("Input -> "+ ctx.getChild(1).getChild(1).getChild(1).getText());
			//pw.write("Input -> "+ ctx.getChild(1).getChild(1).getChild(1).getText());
			break;
		}
		
		
		
		
		return super.visitParExpression(ctx);
	}

	@Override
	public Integer visitRetValue(TinyPyCParser.RetValueContext ctx) {
		pw.println("RET "+ctx.getChild(0).getText());
		return super.visitRetValue(ctx);
	}

	@Override
	public Integer visitPrimary(TinyPyCParser.PrimaryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimary(ctx);
	}
	
}