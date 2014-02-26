from marketsim import registry
from marketsim.gen._out._observable._observablefloat import Observablefloat
from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
@registry.expose(["Log/Pow", "Exp"])
class Exp_Float(Observablefloat):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out._observable._observablefloat import Observablefloat
        from marketsim.gen._out._constant import constant_Float as _constant_Float
        from marketsim import rtti
        Observablefloat.__init__(self)
        self.x = x if x is not None else _constant_Float(1.0)
        
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : IFunctionfloat
    }
    def __repr__(self):
        return "e^{%(x)s}" % self.__dict__
    
    def __call__(self, *args, **kwargs):
        import math
        x = self.x()
        if x is None: return None
        return math.exp(x)
    
def Exp(x = None): 
    from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
    from marketsim import rtti
    if x is None or rtti.can_be_casted(x, IFunctionfloat):
        return Exp_Float(x)
    raise Exception('Cannot find suitable overload for Exp('+str(x) +':'+ str(type(x))+')')
