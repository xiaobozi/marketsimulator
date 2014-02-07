from marketsim import registry
from marketsim import float
from marketsim.ops._function import Function
from marketsim.gen._intrinsic._constant import _Constant_Impl
@registry.expose(["Basic", "const"])
class const_Float(Function[float],_Constant_Impl):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim import rtti
        self.x = x if x is not None else 1.0
        rtti.check_fields(self)
        _Constant_Impl.__init__(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : float
    }
    def __repr__(self):
        return "C=%(x)s" % self.__dict__
    
def const(x = None): 
    from marketsim import float
    from marketsim import rtti
    if x is None or rtti.can_be_casted(x, float):
        return const_Float(x)
    raise Exception("Cannot find suitable overload")
