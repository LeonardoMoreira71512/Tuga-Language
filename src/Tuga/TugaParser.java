// Generated from C:/3ANO_2VEZ/Compiladores/Tuga/Tuga/src/Tuga.g4 by ANTLR 4.13.1
package Tuga;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TugaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DOUBLE=6, STRING=7, BOOLEAN=8, 
		ESCREVE=9, RETORNA=10, VERDADEIRO=11, FALSO=12, TypeINT=13, TypeDOUBLE=14, 
		TypeSTRING=15, TypeBOOL=16, INICIO=17, FIM=18, ENQUANTO=19, SE=20, SENAO=21, 
		FUNCAO=22, LPAREN=23, RPAREN=24, MINUS=25, ADD=26, MULT=27, DIV=28, MOD=29, 
		GT=30, LT=31, GET=32, LET=33, IGUAL=34, DIFERENTE=35, NAO=36, E=37, OU=38, 
		VAR_NAME=39, WS=40, SL_COMMENT=41, ML_COMMENT=42, LETTER=43;
	public static final int
		RULE_program = 0, RULE_functionDeclaration = 1, RULE_arguments = 2, RULE_parameter = 3, 
		RULE_varDeclaration = 4, RULE_type = 5, RULE_inst = 6, RULE_funcCall = 7, 
		RULE_bloco = 8, RULE_enquanto = 9, RULE_seSenao = 10, RULE_expr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDeclaration", "arguments", "parameter", "varDeclaration", 
			"type", "inst", "funcCall", "bloco", "enquanto", "seSenao", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'<-'", null, null, null, null, "'escreve'", 
			"'retorna'", "'verdadeiro'", "'falso'", "'inteiro'", "'real'", "'string'", 
			"'booleano'", "'inicio'", "'fim'", "'enquanto'", "'se'", "'senao'", "'funcao'", 
			"'('", "')'", "'-'", "'+'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", 
			"'<='", "'igual'", "'diferente'", "'nao'", "'e'", "'ou'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT", "DOUBLE", "STRING", "BOOLEAN", "ESCREVE", 
			"RETORNA", "VERDADEIRO", "FALSO", "TypeINT", "TypeDOUBLE", "TypeSTRING", 
			"TypeBOOL", "INICIO", "FIM", "ENQUANTO", "SE", "SENAO", "FUNCAO", "LPAREN", 
			"RPAREN", "MINUS", "ADD", "MULT", "DIV", "MOD", "GT", "LT", "GET", "LET", 
			"IGUAL", "DIFERENTE", "NAO", "E", "OU", "VAR_NAME", "WS", "SL_COMMENT", 
			"ML_COMMENT", "LETTER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tuga.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TugaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TugaParser.EOF, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(24);
				varDeclaration();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				functionDeclaration();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNCAO );
			setState(35);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCAO() { return getToken(TugaParser.FUNCAO, 0); }
		public TerminalNode VAR_NAME() { return getToken(TugaParser.VAR_NAME, 0); }
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(FUNCAO);
			setState(38);
			match(VAR_NAME);
			setState(39);
			match(LPAREN);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR_NAME) {
				{
				setState(40);
				arguments();
				}
			}

			setState(43);
			match(RPAREN);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(44);
				match(T__0);
				setState(45);
				type();
				}
			}

			setState(48);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			parameter();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(51);
				match(T__1);
				setState(52);
				parameter();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode VAR_NAME() { return getToken(TugaParser.VAR_NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(VAR_NAME);
			setState(59);
			match(T__0);
			setState(60);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> VAR_NAME() { return getTokens(TugaParser.VAR_NAME); }
		public TerminalNode VAR_NAME(int i) {
			return getToken(TugaParser.VAR_NAME, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(VAR_NAME);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(63);
				match(T__1);
				setState(64);
				match(VAR_NAME);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__0);
			setState(71);
			type();
			setState(72);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TypeINT() { return getToken(TugaParser.TypeINT, 0); }
		public TerminalNode TypeDOUBLE() { return getToken(TugaParser.TypeDOUBLE, 0); }
		public TerminalNode TypeSTRING() { return getToken(TugaParser.TypeSTRING, 0); }
		public TerminalNode TypeBOOL() { return getToken(TugaParser.TypeBOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 122880L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstContext extends ParserRuleContext {
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
	 
		public InstContext() { }
		public void copyFrom(InstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends InstContext {
		public TerminalNode ESCREVE() { return getToken(TugaParser.ESCREVE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyContext extends InstContext {
		public EmptyContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends InstContext {
		public TerminalNode RETORNA() { return getToken(TugaParser.RETORNA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends InstContext {
		public SeSenaoContext seSenao() {
			return getRuleContext(SeSenaoContext.class,0);
		}
		public IfElseContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends InstContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public BlockContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends InstContext {
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public WhileContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidFunctionCallContext extends InstContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public VoidFunctionCallContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVoidFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVoidFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVoidFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AfectionContext extends InstContext {
		public TerminalNode VAR_NAME() { return getToken(TugaParser.VAR_NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AfectionContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterAfection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitAfection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitAfection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inst);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(ESCREVE);
				setState(77);
				expr(0);
				setState(78);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new AfectionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(VAR_NAME);
				setState(81);
				match(T__3);
				setState(82);
				expr(0);
				setState(83);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				bloco();
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				enquanto();
				}
				break;
			case 5:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				seSenao();
				}
				break;
			case 6:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(RETORNA);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 618517234144L) != 0)) {
					{
					setState(89);
					expr(0);
					}
				}

				setState(92);
				match(T__2);
				}
				break;
			case 7:
				_localctx = new VoidFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				funcCall();
				setState(94);
				match(T__2);
				}
				break;
			case 8:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode VAR_NAME() { return getToken(TugaParser.VAR_NAME, 0); }
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(VAR_NAME);
			setState(100);
			match(LPAREN);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 618517234144L) != 0)) {
				{
				setState(101);
				expr(0);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(102);
					match(T__1);
					setState(103);
					expr(0);
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(111);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(TugaParser.INICIO, 0); }
		public TerminalNode FIM() { return getToken(TugaParser.FIM, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitBloco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloco);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(INICIO);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					varDeclaration();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549757519368L) != 0)) {
				{
				{
				setState(120);
				inst();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(FIM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnquantoContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(TugaParser.ENQUANTO, 0); }
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public EnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(ENQUANTO);
			setState(129);
			match(LPAREN);
			setState(130);
			expr(0);
			setState(131);
			match(RPAREN);
			setState(132);
			inst();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeSenaoContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(TugaParser.SE, 0); }
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(TugaParser.SENAO, 0); }
		public SeSenaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seSenao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterSeSenao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitSeSenao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitSeSenao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeSenaoContext seSenao() throws RecognitionException {
		SeSenaoContext _localctx = new SeSenaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_seSenao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(SE);
			setState(135);
			match(LPAREN);
			setState(136);
			expr(0);
			setState(137);
			match(RPAREN);
			setState(138);
			inst();
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(139);
				match(SENAO);
				setState(140);
				inst();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExprContext {
		public TerminalNode VAR_NAME() { return getToken(TugaParser.VAR_NAME, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TugaParser.MINUS, 0); }
		public TerminalNode NAO() { return getToken(TugaParser.NAO, 0); }
		public NegationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(TugaParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(TugaParser.MINUS, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode E() { return getToken(TugaParser.E, 0); }
		public EContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OUContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OU() { return getToken(TugaParser.OU, 0); }
		public OUContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterOU(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitOU(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitOU(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(TugaParser.GT, 0); }
		public TerminalNode LT() { return getToken(TugaParser.LT, 0); }
		public TerminalNode GET() { return getToken(TugaParser.GET, 0); }
		public TerminalNode LET() { return getToken(TugaParser.LET, 0); }
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(TugaParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleContext extends ExprContext {
		public TerminalNode DOUBLE() { return getToken(TugaParser.DOUBLE, 0); }
		public DoubleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(TugaParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EquilityContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(TugaParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(TugaParser.DIFERENTE, 0); }
		public EquilityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterEquility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitEquility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitEquility(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExprContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(TugaParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(TugaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(TugaParser.MOD, 0); }
		public MultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(TugaParser.BOOLEAN, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public ParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(144);
				match(LPAREN);
				setState(145);
				expr(0);
				setState(146);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				((NegationContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NAO) ) {
					((NegationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(149);
				expr(13);
				}
				break;
			case 3:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(INT);
				}
				break;
			case 4:
				{
				_localctx = new DoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(DOUBLE);
				}
				break;
			case 5:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(STRING);
				}
				break;
			case 6:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(BOOLEAN);
				}
				break;
			case 7:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(VAR_NAME);
				}
				break;
			case 8:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(159);
						((MultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
							((MultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(162);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==ADD) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(163);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(165);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(166);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EquilityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(168);
						((EquilityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==DIFERENTE) ) {
							((EquilityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new EContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(171);
						match(E);
						setState(172);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new OUContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(174);
						match(OU);
						setState(175);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u00b6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d\t\u0000\u0001\u0000"+
		"\u0004\u0000 \b\u0000\u000b\u0000\f\u0000!\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00026\b\u0002\n\u0002"+
		"\f\u00029\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004\f\u0004E\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006[\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006b\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007i\b"+
		"\u0007\n\u0007\f\u0007l\t\u0007\u0003\u0007n\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0005\bt\b\b\n\b\f\bw\t\b\u0001\b\u0005\bz\b\b"+
		"\n\b\f\b}\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u008e\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u009d\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b1\b\u000b"+
		"\n\u000b\f\u000b\u00b4\t\u000b\u0001\u000b\u0000\u0001\u0016\f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0006\u0001\u0000"+
		"\r\u0010\u0002\u0000\u0019\u0019$$\u0001\u0000\u001b\u001d\u0001\u0000"+
		"\u0019\u001a\u0001\u0000\u001e!\u0001\u0000\"#\u00c9\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000"+
		"\u0000\u0006:\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\nJ\u0001"+
		"\u0000\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000"+
		"\u0000\u0010q\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000"+
		"\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u009c\u0001\u0000\u0000\u0000"+
		"\u0018\u001a\u0003\b\u0004\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005"+
		"\u0000\u0000\u0001$\u0001\u0001\u0000\u0000\u0000%&\u0005\u0016\u0000"+
		"\u0000&\'\u0005\'\u0000\u0000\')\u0005\u0017\u0000\u0000(*\u0003\u0004"+
		"\u0002\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001"+
		"\u0000\u0000\u0000+.\u0005\u0018\u0000\u0000,-\u0005\u0001\u0000\u0000"+
		"-/\u0003\n\u0005\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000001\u0003\u0010\b\u00001\u0003\u0001\u0000\u0000"+
		"\u000027\u0003\u0006\u0003\u000034\u0005\u0002\u0000\u000046\u0003\u0006"+
		"\u0003\u000053\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u0000:;\u0005\'\u0000\u0000;<\u0005\u0001\u0000"+
		"\u0000<=\u0003\n\u0005\u0000=\u0007\u0001\u0000\u0000\u0000>C\u0005\'"+
		"\u0000\u0000?@\u0005\u0002\u0000\u0000@B\u0005\'\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"FG\u0005\u0001\u0000\u0000GH\u0003\n\u0005\u0000HI\u0005\u0003\u0000\u0000"+
		"I\t\u0001\u0000\u0000\u0000JK\u0007\u0000\u0000\u0000K\u000b\u0001\u0000"+
		"\u0000\u0000LM\u0005\t\u0000\u0000MN\u0003\u0016\u000b\u0000NO\u0005\u0003"+
		"\u0000\u0000Ob\u0001\u0000\u0000\u0000PQ\u0005\'\u0000\u0000QR\u0005\u0004"+
		"\u0000\u0000RS\u0003\u0016\u000b\u0000ST\u0005\u0003\u0000\u0000Tb\u0001"+
		"\u0000\u0000\u0000Ub\u0003\u0010\b\u0000Vb\u0003\u0012\t\u0000Wb\u0003"+
		"\u0014\n\u0000XZ\u0005\n\u0000\u0000Y[\u0003\u0016\u000b\u0000ZY\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\b\u0005\u0003\u0000\u0000]^\u0003\u000e\u0007\u0000^_\u0005\u0003\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`b\u0005\u0003\u0000\u0000aL\u0001\u0000"+
		"\u0000\u0000aP\u0001\u0000\u0000\u0000aU\u0001\u0000\u0000\u0000aV\u0001"+
		"\u0000\u0000\u0000aW\u0001\u0000\u0000\u0000aX\u0001\u0000\u0000\u0000"+
		"a]\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000b\r\u0001\u0000\u0000"+
		"\u0000cd\u0005\'\u0000\u0000dm\u0005\u0017\u0000\u0000ej\u0003\u0016\u000b"+
		"\u0000fg\u0005\u0002\u0000\u0000gi\u0003\u0016\u000b\u0000hf\u0001\u0000"+
		"\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"me\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0005\u0018\u0000\u0000p\u000f\u0001\u0000\u0000\u0000qu\u0005"+
		"\u0011\u0000\u0000rt\u0003\b\u0004\u0000sr\u0001\u0000\u0000\u0000tw\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v{\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0003\f\u0006\u0000"+
		"yx\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\u0012\u0000\u0000\u007f\u0011\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005\u0013\u0000\u0000\u0081\u0082\u0005\u0017\u0000"+
		"\u0000\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0084\u0005\u0018\u0000"+
		"\u0000\u0084\u0085\u0003\f\u0006\u0000\u0085\u0013\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\u0014\u0000\u0000\u0087\u0088\u0005\u0017\u0000\u0000"+
		"\u0088\u0089\u0003\u0016\u000b\u0000\u0089\u008a\u0005\u0018\u0000\u0000"+
		"\u008a\u008d\u0003\f\u0006\u0000\u008b\u008c\u0005\u0015\u0000\u0000\u008c"+
		"\u008e\u0003\f\u0006\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u0015\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0006\u000b\uffff\uffff\u0000\u0090\u0091\u0005\u0017\u0000\u0000\u0091"+
		"\u0092\u0003\u0016\u000b\u0000\u0092\u0093\u0005\u0018\u0000\u0000\u0093"+
		"\u009d\u0001\u0000\u0000\u0000\u0094\u0095\u0007\u0001\u0000\u0000\u0095"+
		"\u009d\u0003\u0016\u000b\r\u0096\u009d\u0005\u0005\u0000\u0000\u0097\u009d"+
		"\u0005\u0006\u0000\u0000\u0098\u009d\u0005\u0007\u0000\u0000\u0099\u009d"+
		"\u0005\b\u0000\u0000\u009a\u009d\u0005\'\u0000\u0000\u009b\u009d\u0003"+
		"\u000e\u0007\u0000\u009c\u008f\u0001\u0000\u0000\u0000\u009c\u0094\u0001"+
		"\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u0097\u0001"+
		"\u0000\u0000\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u00b2\u0001\u0000\u0000\u0000\u009e\u009f\n\f"+
		"\u0000\u0000\u009f\u00a0\u0007\u0002\u0000\u0000\u00a0\u00b1\u0003\u0016"+
		"\u000b\r\u00a1\u00a2\n\u000b\u0000\u0000\u00a2\u00a3\u0007\u0003\u0000"+
		"\u0000\u00a3\u00b1\u0003\u0016\u000b\f\u00a4\u00a5\n\n\u0000\u0000\u00a5"+
		"\u00a6\u0007\u0004\u0000\u0000\u00a6\u00b1\u0003\u0016\u000b\u000b\u00a7"+
		"\u00a8\n\t\u0000\u0000\u00a8\u00a9\u0007\u0005\u0000\u0000\u00a9\u00b1"+
		"\u0003\u0016\u000b\n\u00aa\u00ab\n\b\u0000\u0000\u00ab\u00ac\u0005%\u0000"+
		"\u0000\u00ac\u00b1\u0003\u0016\u000b\t\u00ad\u00ae\n\u0007\u0000\u0000"+
		"\u00ae\u00af\u0005&\u0000\u0000\u00af\u00b1\u0003\u0016\u000b\b\u00b0"+
		"\u009e\u0001\u0000\u0000\u0000\u00b0\u00a1\u0001\u0000\u0000\u0000\u00b0"+
		"\u00a4\u0001\u0000\u0000\u0000\u00b0\u00a7\u0001\u0000\u0000\u0000\u00b0"+
		"\u00aa\u0001\u0000\u0000\u0000\u00b0\u00ad\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b3\u0017\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b2\u0001\u0000\u0000\u0000\u0010\u001b!).7CZajmu{\u008d\u009c\u00b0"+
		"\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}