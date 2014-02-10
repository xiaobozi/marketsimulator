from marketsim import registry
from marketsim import IOrderGenerator
from marketsim import float
from marketsim import IFunction
@registry.expose(["Order", "MarketSigned"])
class signedVolume_MarketSigned_(IFunction[IOrderGenerator, IFunction[float]]):
    """ 
      Market order intructs buy or sell given volume immediately
    """ 
    def __init__(self):
        from marketsim import rtti
        
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        
    }
    def __repr__(self):
        return "MarketSigned" % self.__dict__
    
    def __call__(self, signedVolume = None):
        from marketsim.gen._out._constant import constant_Float as _constant
        from marketsim.gen._out.order._marketsigned import MarketSigned
        signedVolume = signedVolume if signedVolume is not None else _constant(1.0)
        
        return MarketSigned(signedVolume)
    
def signedVolume_MarketSigned(): 
    from marketsim import rtti
    return signedVolume_MarketSigned_()
    raise Exception("Cannot find suitable overload")
