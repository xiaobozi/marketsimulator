from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
from marketsim.gen._out._ievent import IEvent
from marketsim.gen._out._ifunction._ifunctionobjectifunctionfloat import IFunctionobjectIFunctionfloat
from marketsim import meta
#(() => .Float) => .IEvent
class IFunctionIEventIFunctionfloat(object):
    _types = [meta.function((IFunctionfloat,),IEvent)]
    _types.append(IFunctionobjectIFunctionfloat)
    pass


