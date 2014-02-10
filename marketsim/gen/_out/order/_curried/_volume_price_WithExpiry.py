from marketsim import registry
from marketsim import IOrderGenerator
from marketsim import float
from marketsim import IFunction
@registry.expose(["Order", "price_WithExpiry"])
class volume_price_WithExpiry_IFunctionFloatFloatFloatIOrderGenerator(IFunction[IFunction[IOrderGenerator,IFunction[float]],IFunction[float]]):
    """ 
     WithExpiry orders can be viewed as ImmediateOrCancel orders
     where cancel order is sent not immediately but after some delay
    """ 
    def __init__(self, expiry = None, proto = None):
        from marketsim.gen._out._constant import constant_Float as _constant
        from marketsim.gen._out.order._curried._volume_price_limit import volume_price_Limit_Side as _order__curried_volume_price_Limit
        from marketsim import rtti
        self.expiry = expiry if expiry is not None else _constant(10.0)
        self.proto = proto if proto is not None else _order__curried_volume_price_Limit()
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'expiry' : IFunction[float],
        'proto' : IFunction[IFunction[IOrderGenerator, IFunction[float]], IFunction[float]]
    }
    def __repr__(self):
        return "price_WithExpiry(%(expiry)s, %(proto)s)" % self.__dict__
    
    def __call__(self, volume = None):
        from marketsim.gen._out._constant import constant_Float as _constant
        from marketsim.gen._out.order._curried._price_withexpiry import price_WithExpiry
        volume = volume if volume is not None else _constant(1.0)
        expiry = self.expiry
        proto = self.proto
        return price_WithExpiry(expiry, proto(volume))
    
def volume_price_WithExpiry(expiry = None,proto = None): 
    from marketsim import IFunction
    from marketsim import float
    from marketsim import IOrderGenerator
    from marketsim import rtti
    if expiry is None or rtti.can_be_casted(expiry, IFunction[float]):
        if proto is None or rtti.can_be_casted(proto, IFunction[IFunction[IOrderGenerator,IFunction[float]],IFunction[float]]):
            return volume_price_WithExpiry_IFunctionFloatFloatFloatIOrderGenerator(expiry,proto)
    raise Exception("Cannot find suitable overload")
