// Generated from TinyPyC.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyPyCParser}.
 */
public interface TinyPyCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull TinyPyCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull TinyPyCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(@NotNull TinyPyCParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(@NotNull TinyPyCParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull TinyPyCParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull TinyPyCParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#start_prog}.
	 * @param ctx the parse tree
	 */
	void enterStart_prog(@NotNull TinyPyCParser.Start_progContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#start_prog}.
	 * @param ctx the parse tree
	 */
	void exitStart_prog(@NotNull TinyPyCParser.Start_progContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull TinyPyCParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull TinyPyCParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#functionStart}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStart(@NotNull TinyPyCParser.FunctionStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#functionStart}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStart(@NotNull TinyPyCParser.FunctionStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(@NotNull TinyPyCParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(@NotNull TinyPyCParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#conditionalStart}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStart(@NotNull TinyPyCParser.ConditionalStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#conditionalStart}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStart(@NotNull TinyPyCParser.ConditionalStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#paramsCall}.
	 * @param ctx the parse tree
	 */
	void enterParamsCall(@NotNull TinyPyCParser.ParamsCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#paramsCall}.
	 * @param ctx the parse tree
	 */
	void exitParamsCall(@NotNull TinyPyCParser.ParamsCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#conditionalEnd}.
	 * @param ctx the parse tree
	 */
	void enterConditionalEnd(@NotNull TinyPyCParser.ConditionalEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#conditionalEnd}.
	 * @param ctx the parse tree
	 */
	void exitConditionalEnd(@NotNull TinyPyCParser.ConditionalEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(@NotNull TinyPyCParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(@NotNull TinyPyCParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(@NotNull TinyPyCParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(@NotNull TinyPyCParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull TinyPyCParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull TinyPyCParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(@NotNull TinyPyCParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(@NotNull TinyPyCParser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#paramListCall}.
	 * @param ctx the parse tree
	 */
	void enterParamListCall(@NotNull TinyPyCParser.ParamListCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#paramListCall}.
	 * @param ctx the parse tree
	 */
	void exitParamListCall(@NotNull TinyPyCParser.ParamListCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull TinyPyCParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull TinyPyCParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull TinyPyCParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull TinyPyCParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#conditionElse}.
	 * @param ctx the parse tree
	 */
	void enterConditionElse(@NotNull TinyPyCParser.ConditionElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#conditionElse}.
	 * @param ctx the parse tree
	 */
	void exitConditionElse(@NotNull TinyPyCParser.ConditionElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#formalParameterCall}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterCall(@NotNull TinyPyCParser.FormalParameterCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#formalParameterCall}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterCall(@NotNull TinyPyCParser.FormalParameterCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#stackOperation}.
	 * @param ctx the parse tree
	 */
	void enterStackOperation(@NotNull TinyPyCParser.StackOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#stackOperation}.
	 * @param ctx the parse tree
	 */
	void exitStackOperation(@NotNull TinyPyCParser.StackOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#vsc}.
	 * @param ctx the parse tree
	 */
	void enterVsc(@NotNull TinyPyCParser.VscContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#vsc}.
	 * @param ctx the parse tree
	 */
	void exitVsc(@NotNull TinyPyCParser.VscContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#boolValues}.
	 * @param ctx the parse tree
	 */
	void enterBoolValues(@NotNull TinyPyCParser.BoolValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#boolValues}.
	 * @param ctx the parse tree
	 */
	void exitBoolValues(@NotNull TinyPyCParser.BoolValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(@NotNull TinyPyCParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(@NotNull TinyPyCParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#loopStart}.
	 * @param ctx the parse tree
	 */
	void enterLoopStart(@NotNull TinyPyCParser.LoopStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#loopStart}.
	 * @param ctx the parse tree
	 */
	void exitLoopStart(@NotNull TinyPyCParser.LoopStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#stackReturnOp}.
	 * @param ctx the parse tree
	 */
	void enterStackReturnOp(@NotNull TinyPyCParser.StackReturnOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#stackReturnOp}.
	 * @param ctx the parse tree
	 */
	void exitStackReturnOp(@NotNull TinyPyCParser.StackReturnOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull TinyPyCParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull TinyPyCParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(@NotNull TinyPyCParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(@NotNull TinyPyCParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#functionEnd}.
	 * @param ctx the parse tree
	 */
	void enterFunctionEnd(@NotNull TinyPyCParser.FunctionEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#functionEnd}.
	 * @param ctx the parse tree
	 */
	void exitFunctionEnd(@NotNull TinyPyCParser.FunctionEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#startbracket}.
	 * @param ctx the parse tree
	 */
	void enterStartbracket(@NotNull TinyPyCParser.StartbracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#startbracket}.
	 * @param ctx the parse tree
	 */
	void exitStartbracket(@NotNull TinyPyCParser.StartbracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull TinyPyCParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull TinyPyCParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(@NotNull TinyPyCParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(@NotNull TinyPyCParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#els}.
	 * @param ctx the parse tree
	 */
	void enterEls(@NotNull TinyPyCParser.ElsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#els}.
	 * @param ctx the parse tree
	 */
	void exitEls(@NotNull TinyPyCParser.ElsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull TinyPyCParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull TinyPyCParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#loopend}.
	 * @param ctx the parse tree
	 */
	void enterLoopend(@NotNull TinyPyCParser.LoopendContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#loopend}.
	 * @param ctx the parse tree
	 */
	void exitLoopend(@NotNull TinyPyCParser.LoopendContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull TinyPyCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull TinyPyCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(@NotNull TinyPyCParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(@NotNull TinyPyCParser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(@NotNull TinyPyCParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(@NotNull TinyPyCParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(@NotNull TinyPyCParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(@NotNull TinyPyCParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#end_prog}.
	 * @param ctx the parse tree
	 */
	void enterEnd_prog(@NotNull TinyPyCParser.End_progContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#end_prog}.
	 * @param ctx the parse tree
	 */
	void exitEnd_prog(@NotNull TinyPyCParser.End_progContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull TinyPyCParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull TinyPyCParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#varaiableInitialization}.
	 * @param ctx the parse tree
	 */
	void enterVaraiableInitialization(@NotNull TinyPyCParser.VaraiableInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#varaiableInitialization}.
	 * @param ctx the parse tree
	 */
	void exitVaraiableInitialization(@NotNull TinyPyCParser.VaraiableInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#endbracket}.
	 * @param ctx the parse tree
	 */
	void enterEndbracket(@NotNull TinyPyCParser.EndbracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#endbracket}.
	 * @param ctx the parse tree
	 */
	void exitEndbracket(@NotNull TinyPyCParser.EndbracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(@NotNull TinyPyCParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(@NotNull TinyPyCParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPyCParser#retValue}.
	 * @param ctx the parse tree
	 */
	void enterRetValue(@NotNull TinyPyCParser.RetValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPyCParser#retValue}.
	 * @param ctx the parse tree
	 */
	void exitRetValue(@NotNull TinyPyCParser.RetValueContext ctx);
}