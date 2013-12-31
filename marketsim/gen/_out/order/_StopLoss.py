from marketsim import registry
from marketsim import IOrderGenerator
from marketsim import Order
from marketsim.ops._all import Observable
from marketsim import IObservable
from marketsim import IObservable
from marketsim import Order
@registry.expose(["Order", "StopLoss"])
class StopLoss(IOrderGenerator, Observable[Order]):
    """ 
    """ 
    def __init__(self, maxloss = None, proto = None):
        from marketsim import Order
        from marketsim.ops._all import Observable
        from marketsim.gen._out._const import const
        from marketsim import event
        from marketsim import types
        from marketsim.gen._out.order._Market import Market
        from marketsim import event
        from marketsim import types
        Observable[Order].__init__(self)
        self.maxloss = maxloss if maxloss is not None else const(0.1)
        if isinstance(maxloss, types.IEvent):
            event.subscribe(self.maxloss, self.fire, self)
        self.proto = proto if proto is not None else Market()
        if isinstance(proto, types.IEvent):
            event.subscribe(self.proto, self.fire, self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'maxloss' : IObservable[float],
        'proto' : IObservable[Order]
        
    }
    def __repr__(self):
        return "StopLoss(%(maxloss)s, %(proto)s)" % self.__dict__
    
    def __call__(self, *args, **kwargs):
        from marketsim.gen._intrinsic.order.meta.stoploss import Order_Impl
        maxloss = self.maxloss()
        if maxloss is None: return None
        
        proto = self.proto()
        if proto is None: return None
        
        return Order_Impl(maxloss, proto)
    


from marketsim import registry
from marketsim.types import sig
from marketsim import IFunction
from marketsim import Side
from marketsim import IObservable
from marketsim import meta
from marketsim import IOrderGenerator
@registry.expose(["Order", "StopLoss"])
@sig((IFunction[Side],), IOrderGenerator)
class side_StopLoss(object):
    """ 
    """ 
    def __init__(self, maxloss = None, proto = None):
        from marketsim.gen._out._const import const
        from marketsim.gen._out.order._Market import side_Market
        self.maxloss = maxloss if maxloss is not None else const(0.1)
        self.proto = proto if proto is not None else side_Market()
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'maxloss' : IObservable[float],
        'proto' : meta.function((IFunction[Side],), IOrderGenerator)
    }
    def __repr__(self):
        return "side_StopLoss(%(maxloss)s, %(proto)s)" % self.__dict__
    
    def __call__(self, side = None):
        maxloss = self.maxloss
        proto = self.proto
        return StopLoss(self.maxloss, self.proto(side))
    
