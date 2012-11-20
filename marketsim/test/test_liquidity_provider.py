from marketsim import strategy, order, orderbook, trader, Side, scheduler

world = scheduler.create()

book = orderbook.Local(tickSize=.001)

"""
t = LiquidityProvider(book)
c = Canceller()
t.on_order_sent.add(c.process)

world.workTill(1000.)
"""

trader = strategy.LiquidityProviderSide(trader.SASM(book),
                           side=Side.Sell,
                           creationIntervalDistr=(lambda: 1),
                           priceDistr=(lambda: 0.5),
                           volumeDistr=(lambda: 10),
                           defaultValue=128).trader

assert book.asks.empty

world.workTill(1.5)

assert book.asks.best.price == 64
assert book.asks.best.volume == 10

world.workTill(2.5)

assert book.asks.best.price == 32
assert book.asks.best.volume == 10

book.process(order.Market.Buy(5))
assert trader.PnL == 32*5

book.process(order.Market.Buy(10))
assert trader.PnL == 32*10 + 64*5

assert book.asks.best.price == 64
assert book.asks.best.volume == 5

canceller = strategy.Canceller(source=trader,cancellationIntervalDistr=(lambda: .2), choiceFunc=(lambda N: 0))

world.workTill(3.05)

assert book.asks.best.price == 32
assert book.asks.best.volume == 10

world.workTill(3.15)

assert book.asks.best.price == 64
assert book.asks.best.volume == 5