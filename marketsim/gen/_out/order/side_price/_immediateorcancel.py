def ImmediateOrCancel(proto = None): 
    from marketsim import IFunction
    from marketsim import rtti
    from marketsim import float
    from marketsim import IOrderGenerator
    from marketsim import Side
    from marketsim.gen._out.order._curried._sideprice_immediateorcancel import sideprice_ImmediateOrCancel_SideFloatIOrderGenerator as _order__curried_sideprice_ImmediateOrCancel
    if proto is None or rtti.can_be_casted(proto, IFunction[IOrderGenerator,IFunction[Side]
    ,IFunction[float]]):
        return _order__curried_sideprice_ImmediateOrCancel(proto)
    raise Exception("Cannot find suitable overload")
