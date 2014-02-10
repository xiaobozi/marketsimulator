def _queue(book = None): 
    from marketsim import IOrderBook
    from marketsim.gen._out.orderbook._bids import Bids_IOrderBook as _orderbook_Bids
    from marketsim import rtti
    if book is None or rtti.can_be_casted(book, IOrderBook):
        return _orderbook_Bids(book)
    raise Exception("Cannot find suitable overload")
