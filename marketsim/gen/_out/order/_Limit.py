from marketsim import Order
from marketsim.ops._all import Observable
from marketsim import IFunction
from marketsim import IOrderGenerator
from marketsim import Side
from marketsim import registry
from marketsim import float
@registry.expose(["Order", "Limit"])
class Limit_SideIFunctionFloatIFunctionFloat(Observable[Order],IOrderGenerator):
    """ 
      Limit orders ask to buy or sell some asset at price better than some limit price.
      If a limit order is not competely fulfilled
      it remains in an order book waiting to be matched with another order.
    """ 
    def __init__(self, side = None, price = None, volume = None):
        from marketsim.gen._out.side._Sell import Sell as _side_Sell
        from marketsim import types
        from marketsim.ops._all import Observable
        from marketsim import rtti
        from marketsim import event
        from marketsim.gen._out._constant import constant as _constant
        from marketsim import Order
        Observable[Order].__init__(self)
        self.side = side if side is not None else _side_Sell()
        if isinstance(side, types.IEvent):
            event.subscribe(self.side, self.fire, self)
        self.price = price if price is not None else _constant(100.0)
        if isinstance(price, types.IEvent):
            event.subscribe(self.price, self.fire, self)
        self.volume = volume if volume is not None else _constant(1.0)
        if isinstance(volume, types.IEvent):
            event.subscribe(self.volume, self.fire, self)
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'side' : IFunction[Side],
        'price' : IFunction[float],
        'volume' : IFunction[float]
    }
    def __repr__(self):
        return "Limit(%(side)s, %(price)s, %(volume)s)" % self.__dict__
    
    def __call__(self, *args, **kwargs):
        from marketsim.gen._intrinsic.order.limit import Order_Impl
        side = self.side()
        if side is None: return None
        
        price = self.price()
        if price is None: return None
        
        volume = self.volume()
        if volume is None: return None
        if abs(volume) < 1: return None
        volume = int(volume)
        return Order_Impl(side, price, volume)
    
def Limit(side = None,price = None,volume = None): 
    from marketsim import Side
    from marketsim import IFunction
    from marketsim import float
    from marketsim import rtti
    if side is None or rtti.can_be_casted(side, IFunction[Side]):
        if price is None or rtti.can_be_casted(price, IFunction[float]):
            if volume is None or rtti.can_be_casted(volume, IFunction[float]):
                return Limit_SideIFunctionFloatIFunctionFloat(side,price,volume)
    raise Exception("Cannot find suitable overload")
