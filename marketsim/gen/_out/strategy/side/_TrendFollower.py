from marketsim import IOrderBook
from marketsim import Side
from marketsim import registry
from marketsim.ops._function import Function
from marketsim import context
from marketsim import float
@registry.expose(["Side function", "TrendFollower"])
class TrendFollower_FloatFloatIOrderBook(Function[Side]):
    """ 
    """ 
    def __init__(self, alpha = None, threshold = None, book = None):
        from marketsim.gen._out.orderbook._oftrader import OfTrader_IAccount as _orderbook_OfTrader
        from marketsim import rtti
        self.alpha = alpha if alpha is not None else 0.15
        self.threshold = threshold if threshold is not None else 0.0
        self.book = book if book is not None else _orderbook_OfTrader()
        rtti.check_fields(self)
        self.impl = self.getImpl()
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'alpha' : float,
        'threshold' : float,
        'book' : IOrderBook
    }
    def __repr__(self):
        return "TrendFollower(%(alpha)s, %(threshold)s, %(book)s)" % self.__dict__
    
    def bind(self, ctx):
        self._ctx = ctx.clone()
    
    _internals = ['impl']
    def __call__(self, *args, **kwargs):
        return self.impl()
    
    def reset(self):
        self.impl = self.getImpl()
        ctx = getattr(self, '_ctx', None)
        if ctx: context.bind(self.impl, ctx)
    
    def getImpl(self):
        from marketsim.gen._out.strategy.side._signal import Signal_IFunctionFloatFloat as _strategy_side_Signal
        from marketsim.gen._out.math._derivative import Derivative_IDifferentiable as _math_Derivative
        from marketsim.gen._out.math.EW._avg import Avg_IObservableFloatFloat as _math_EW_Avg
        from marketsim.gen._out.orderbook._midprice import MidPrice_IOrderBook as _orderbook_MidPrice
        return _strategy_side_Signal(_math_Derivative(_math_EW_Avg(_orderbook_MidPrice(self.book),self.alpha)),self.threshold)
    
def TrendFollower(alpha = None,threshold = None,book = None): 
    from marketsim import float
    from marketsim import IOrderBook
    from marketsim import rtti
    if alpha is None or rtti.can_be_casted(alpha, float):
        if threshold is None or rtti.can_be_casted(threshold, float):
            if book is None or rtti.can_be_casted(book, IOrderBook):
                return TrendFollower_FloatFloatIOrderBook(alpha,threshold,book)
    raise Exception("Cannot find suitable overload")
