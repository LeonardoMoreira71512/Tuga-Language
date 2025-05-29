package SemanticAnalysis.SymbolTable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    private final Scope enclosingScope;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();
    private String name;

    public Scope(Scope enclosingScope) {
        this(enclosingScope, "noname");
    }

    public Scope(Scope enclosingScope, String name) {
        this.enclosingScope = enclosingScope;
        this.name = name;
    }

    public void define(Symbol sym) {
        symbols.put(sym.getName(), sym);
        sym.scope = this;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public Symbol resolve_local(String name) {
        return symbols.get(name);
    }

    //backpatch
    public Symbol resolve(String name) {
        Symbol s = resolve_local(name);
        if (s != null) return s;
        if (enclosingScope != null) return enclosingScope.resolve(name);
        return null;
    }


    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + symbols.keySet();
    }
}
