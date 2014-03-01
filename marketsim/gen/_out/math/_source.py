from marketsim import registry
from marketsim.gen._out.math._moving import Moving
@registry.expose(["-", "Source"])
class Source_mathMoving(object):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out.math._moving import Moving_IObservableFloatFloat as _math_Moving_IObservableFloatFloat
        from marketsim import deref_opt
        from marketsim import rtti
        self.x = x if x is not None else deref_opt(_math_Moving_IObservableFloatFloat())
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : Moving
    }
    def __repr__(self):
        return "Moving_{%(timeframe)s}(%(source)s)" % self.__dict__
    
    @property
    def dereference(self):
        return self.x.source
    
from marketsim import registry
from marketsim.gen._out.math._ew import EW
@registry.expose(["-", "Source"])
class Source_mathEW(object):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out.math._ew import EW_IObservableFloatFloat as _math_EW_IObservableFloatFloat
        from marketsim import deref_opt
        from marketsim import rtti
        self.x = x if x is not None else deref_opt(_math_EW_IObservableFloatFloat())
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : EW
    }
    def __repr__(self):
        return "EW_{%(alpha)s}(%(source)s)" % self.__dict__
    
    @property
    def dereference(self):
        return self.x.source
    
from marketsim import registry
from marketsim.gen._out.math._macd import macd
@registry.expose(["-", "Source"])
class Source_mathmacd(object):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out.math._macd import macd_IObservableFloatFloatFloat as _math_macd_IObservableFloatFloatFloat
        from marketsim import deref_opt
        from marketsim import rtti
        self.x = x if x is not None else deref_opt(_math_macd_IObservableFloatFloatFloat())
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : macd
    }
    def __repr__(self):
        return "MACD_{%(fast)s}^{%(slow)s}(%(source)s)" % self.__dict__
    
    @property
    def dereference(self):
        return self.x.source
    
from marketsim import registry
from marketsim.gen._out.math._cumulative import Cumulative
@registry.expose(["-", "Source"])
class Source_mathCumulative(object):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out.math._cumulative import Cumulative_IObservableFloat as _math_Cumulative_IObservableFloat
        from marketsim import deref_opt
        from marketsim import rtti
        self.x = x if x is not None else deref_opt(_math_Cumulative_IObservableFloat())
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : Cumulative
    }
    def __repr__(self):
        return "Source(%(x)s)" % self.__dict__
    
    @property
    def dereference(self):
        return self.x.source
    
from marketsim import registry
from marketsim.gen._out.math._istatdomain import IStatDomain
@registry.expose(["-", "Source"])
class Source_mathIStatDomain(object):
    """ 
    """ 
    def __init__(self, x = None):
        from marketsim.gen._out.math._istatdomain import IStatDomain_IObservableFloat as _math_IStatDomain_IObservableFloat
        from marketsim import deref_opt
        from marketsim import rtti
        self.x = x if x is not None else deref_opt(_math_IStatDomain_IObservableFloat())
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'x' : IStatDomain
    }
    def __repr__(self):
        return "Source(%(x)s)" % self.__dict__
    
    @property
    def dereference(self):
        return self.x.source
    
def Source(x = None): 
    from marketsim.gen._out.math._istatdomain import IStatDomain
    from marketsim.gen._out.math._cumulative import Cumulative
    from marketsim import rtti
    from marketsim.gen._out.math._macd import macd
    from marketsim.gen._out.math._moving import Moving
    from marketsim.gen._out.math._ew import EW
    if x is None or rtti.can_be_casted(x, Moving):
        return Source_mathMoving(x)
    if x is None or rtti.can_be_casted(x, EW):
        return Source_mathEW(x)
    if x is None or rtti.can_be_casted(x, macd):
        return Source_mathmacd(x)
    if x is None or rtti.can_be_casted(x, Cumulative):
        return Source_mathCumulative(x)
    if x is None or rtti.can_be_casted(x, IStatDomain):
        return Source_mathIStatDomain(x)
    raise Exception('Cannot find suitable overload for Source('+str(x) +':'+ str(type(x))+')')
