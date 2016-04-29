// Generated from TinyPyC.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TinyPyCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TinyPyCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull TinyPyCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOp(@NotNull TinyPyCParser.RelationalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull TinyPyCParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#start_prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_prog(@NotNull TinyPyCParser.Start_progContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(@NotNull TinyPyCParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#functionStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStart(@NotNull TinyPyCParser.FunctionStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(@NotNull TinyPyCParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#conditionalStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStart(@NotNull TinyPyCParser.ConditionalStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#paramsCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsCall(@NotNull TinyPyCParser.ParamsCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#conditionalEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalEnd(@NotNull TinyPyCParser.ConditionalEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(@NotNull TinyPyCParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(@NotNull TinyPyCParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull TinyPyCParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(@NotNull TinyPyCParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#paramListCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamListCall(@NotNull TinyPyCParser.ParamListCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull TinyPyCParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(@NotNull TinyPyCParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#conditionElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionElse(@NotNull TinyPyCParser.ConditionElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#formalParameterCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterCall(@NotNull TinyPyCParser.FormalParameterCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#stackOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackOperation(@NotNull TinyPyCParser.StackOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#vsc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsc(@NotNull TinyPyCParser.VscContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#boolValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValues(@NotNull TinyPyCParser.BoolValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(@NotNull TinyPyCParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#loopStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStart(@NotNull TinyPyCParser.LoopStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#stackReturnOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackReturnOp(@NotNull TinyPyCParser.StackReturnOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull TinyPyCParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(@NotNull TinyPyCParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#functionEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionEnd(@NotNull TinyPyCParser.FunctionEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#startbracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartbracket(@NotNull TinyPyCParser.StartbracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull TinyPyCParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(@NotNull TinyPyCParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#els}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEls(@NotNull TinyPyCParser.ElsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull TinyPyCParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#loopend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopend(@NotNull TinyPyCParser.LoopendContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull TinyPyCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(@NotNull TinyPyCParser.MessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(@NotNull TinyPyCParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(@NotNull TinyPyCParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#end_prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_prog(@NotNull TinyPyCParser.End_progContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull TinyPyCParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#varaiableInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaraiableInitialization(@NotNull TinyPyCParser.VaraiableInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#endbracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndbracket(@NotNull TinyPyCParser.EndbracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(@NotNull TinyPyCParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyPyCParser#retValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetValue(@NotNull TinyPyCParser.RetValueContext ctx);
}