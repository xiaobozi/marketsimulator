
@category = "Side"
package side
{
    /** Observable always equal to Buy side
     */
    @python.intrinsic.observable("side.Buy_Impl")
    def observableBuy() : .IObservable[.Side]
    
    /** Function always returning None of type Side
     */
    def Nothing() = .side.observableNothing() : .IFunction[.Side]
    
    /** Function always returning Buy side
     */
    def Buy() = .side.observableBuy() : .IFunction[.Side]
    
    /** Observable always equal to None of type Side
     */
    @python.intrinsic.observable("side.None_Impl")
    def observableNothing() : .IObservable[.Side]
    
    /** Observable always equal to Sell side
     */
    @python.intrinsic.observable("side.Sell_Impl")
    def observableSell() : .IObservable[.Side]
    
    /** Function always returning Sell side
     */
    def Sell() = .side.observableSell() : .IFunction[.Side]
    
}

@category = "Event"
@method = "N/A"
package event
{
    type IScheduler
    
    type ISubscription
    
    @python.intrinsic("event.GreaterThan_Impl")
    def GreaterThan(bound : .Float,
                    target : .Any) : .Any
    
    /** Event that once at *delay*
     */
    @python.intrinsic("event.After_Impl")
    def After(/** when the event should be fired */ delay = .constant(10.0)) : .IEvent
    
    @python.intrinsic("event.Event_Impl")
    def Event() : .IEvent
    
    /** Scheduler that manages the future event set.
     * Must be a singleton
     */
    @python.intrinsic("scheduler.Scheduler_Impl")
    def createScheduler(currentTime = 0.0) : .event.IScheduler
    
    /** Returns reference to the instance of the scheduler
     */
    @python.intrinsic("scheduler.currentScheduler_Impl")
    def Scheduler() : .event.IScheduler
    
    @python.intrinsic("event.LessThan_Impl")
    def LessThan(bound : .Float,
                 target : .Any) : .Any
    
    @python.intrinsic("event.Subscription_Impl")
    def Subscription(event : .Any,
                     listener : .Any) : .event.ISubscription
    
    /** Event that fires every *intervalFunc* moments of time
     */
    @python.intrinsic("event.Every_Impl")
    def Every(/** interval of time between two events */ intervalFunc = .math.random.expovariate(1.0)) : .IEvent
    
}

@category = "N/A"
package veusz
{
    /** Graph to render at Veusz. Time series are added to it automatically in their constructor
     */
    @python.intrinsic("veusz.Graph_Impl")
    @label = "%(name)s"
    def Graph(name = "graph") : .IGraph
    
    @python.intrinsic("veusz.CSV_Impl")
    def CSV(directory : .String,
            source : .Any,
            attributes : .Any) : .Any
    
    @python.intrinsic("veusz.VolumeLevelProxy_Impl")
    @label = "N/A"
    def VolumeLevelProxy(source : .Any,
                         idx : .Int) : .Any
    
}

@category = "Ops"
package ops
{
    @label = "-%(x)s"
    @python.intrinsic.observable("ops.Negate_Impl")
    def Negate(x = .constant(1.0)) : .IFunction[.Float]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "+"
    @python.intrinsic.observable("ops.Add_Impl")
    def Add(x = .constant(1.0),
            y = .constant(1.0)) : .IFunction[.Float]
    
    @label = "(if %(cond)s then %(ifpart)s else %(elsepart)s)"
    @python.intrinsic.observable("ops.Condition_Impl")
    def Condition(cond = .true(),
                  ifpart = .constant(1.0),
                  elsepart = .constant(1.0)) : .IFunction[.Float]
    
    @label = "(if %(cond)s then %(ifpart)s else %(elsepart)s)"
    @python.intrinsic.observable("ops.Condition_Impl")
    def Condition(cond = .true(),
                  ifpart = .side.Sell(),
                  elsepart = .side.Buy()) : .IFunction[.Side]
    
    @label = "(if %(cond)s then %(ifpart)s else %(elsepart)s)"
    @python.intrinsic.observable("ops.Condition_Impl")
    def Condition(cond = .true(),
                  ifpart = .true(),
                  elsepart = .false()) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "<"
    @python.intrinsic.observable("ops.Less_Impl")
    def Less(x = .constant(1.0),
             y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "and"
    @python.intrinsic.observable("ops.And_Impl")
    def And(x = .true(),
            y = .true()) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "*"
    @python.intrinsic.observable("ops.Mul_Impl")
    def Mul(x = .constant(1.0),
            y = .constant(1.0)) : .IFunction[.Float]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "<>"
    @python.intrinsic.observable("ops.NotEqual_Impl")
    def NotEqual(x = .constant(1.0),
                 y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = ">="
    @python.intrinsic.observable("ops.GreaterEqual_Impl")
    def GreaterEqual(x = .constant(1.0),
                     y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "-"
    @python.intrinsic.observable("ops.Sub_Impl")
    def Sub(x = .constant(1.0),
            y = .constant(1.0)) : .IFunction[.Float]
    
    @label = "\\frac{%(x)s}{%(y)s}"
    @python.intrinsic.observable("ops.Div_Impl")
    def Div(x = .constant(1.0),
            y = .constant(1.0)) : .IFunction[.Float]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "<="
    @python.intrinsic.observable("ops.LessEqual_Impl")
    def LessEqual(x = .constant(1.0),
                  y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "=="
    @python.intrinsic.observable("ops.Equal_Impl")
    def Equal(x = .constant(1.0),
              y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = ">"
    @python.intrinsic.observable("ops.Greater_Impl")
    def Greater(x = .constant(1.0),
                y = .constant(1.0)) : .IFunction[.Boolean]
    
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @symbol = "or"
    @python.intrinsic.observable("ops.Or_Impl")
    def Or(x = .true(),
           y = .true()) : .IFunction[.Boolean]
    
}

@category = "Basic"
package math
{
    package random
    {
        /** Gamma distribution
         *
         *  Conditions on the parameters are |alpha| > 0 and |beta| > 0.
         *
         *  The probability distribution function is: ::
         *
         *               x ** (alpha - 1) * math.exp(-x / beta)
         *     pdf(x) =  --------------------------------------
         *                  math.gamma(alpha) * beta ** alpha
         */
        @python.random()
        def gammavariate(Alpha = 1.0,
                         Beta = 1.0) : () => .Float
        
        /** Normal distribution
         */
        @python.random()
        def normalvariate(/** |mu| is the mean                  */ Mu = 0.0,
                          /** |sigma| is the standard deviation */ Sigma = 1.0) : () => .Float
        
        /** Pareto distribution
         */
        @python.random()
        def paretovariate(/** |alpha| is the shape parameter*/ Alpha = 1.0) : () => .Float
        
        /** Triangular distribution
         *
         * Return a random floating point number *N* such that *low* <= *N* <= *high* and
         *       with the specified *mode* between those bounds.
         *       The *low* and *high* bounds default to zero and one.
         *       The *mode* argument defaults to the midpoint between the bounds,
         *       giving a symmetric distribution.
         */
        @python.random()
        def triangular(Low = 0.0,
                       High = 1.0,
                       Mode = 0.5) : () => .Float
        
        /** Von Mises distribution
         */
        @python.random()
        def vonmisesvariate(/** |mu| is the mean angle, expressed in radians between 0 and 2|pi|*/ Mu = 0.0,
                            /** |kappa| is the concentration parameter, which must be greater than or equal to zero.
                              *      If |kappa| is equal to zero, this distribution reduces
                              *      to a uniform random angle over the range 0 to 2|pi|        */ Kappa = 0.0) : () => .Float
        
        /** Uniform distribution
         *
         * Return a random floating point number *N* such that
         * *a* <= *N* <= *b* for *a* <= *b* and *b* <= *N* <= *a* for *b* < *a*.
         * The end-point value *b* may or may not be included in the range depending on
         * floating-point rounding in the equation *a* + (*b*-*a*) * *random()*.
         */
        @python.random()
        def uniform(Low = -10.0,
                    High = 10.0) : () => .Float
        
        /** Weibull distribution
         */
        @python.random()
        def weibullvariate(/** |alpha| is the scale parameter */ Alpha = 1.0,
                           /** |beta| is the shape parameter  */ Beta = 1.0) : () => .Float
        
        /** Exponential distribution
         *
         *  Returned values range from 0 to positive infinity
         */
        @python.random()
        def expovariate(/** |lambda| is 1.0 divided by the desired mean. It should be greater zero.*/ Lambda = 1.0) : () => .Float
        
        /** Log normal distribution
         *
         * If you take the natural logarithm of this distribution,
         *  you'll get a normal distribution with mean |mu| and standard deviation |sigma|.
         *  |mu| can have any value, and |sigma| must be greater than zero.
         */
        @python.random()
        def lognormvariate(Mu = 0.0,
                           Sigma = 1.0) : () => .Float
        
        /** Beta distribution
         *
         * Conditions on the parameters are |alpha| > 0 and |beta| > 0.
         * Returned values range between 0 and 1.
         */
        @python.random()
        def betavariate(Alpha = 1.0,
                        Beta = 1.0) : () => .Float
        
    }
    
    abstract type IStatDomain(source = .const(0.0))
    
    type Cumulative(source = .const(0.0)) : IStatDomain
    
    @label = "RSIRaw_{%(timeframe)s}^{%(alpha)s}(%(source)s)"
    type RSI(/** observable data source */ source = .const(1.0),/** lag size */ timeframe = 10.0,/** alpha parameter for EWMA */ alpha = 0.015)
    
    @label = "MACD_{%(fast)s}^{%(slow)s}(%(source)s)"
    type macd(/** source */ source = .const(1.0),/** long period */ slow = 26.0,/** short period */ fast = 12.0)
    
    @label = "EW_{%(alpha)s}(%(source)s)"
    type EW(source = .const(0.0),alpha = 0.015) : IStatDomain
    
    @label = "Moving_{%(timeframe)s}(%(source)s)"
    type Moving(source = .const(0.0),timeframe = 100.0) : IStatDomain
    
    /** Function returning minimum of two functions *x* and *y*.
     * If *x* or/and *y* are observables, *Min* is also observable
     */
    @python.observable()
    @label = "min{%(x)s, %(y)s}"
    def Min(x = .constant(1.0),
            y = .constant(1.0)) = if x<y then x else y
    
    /** Moving average convergence/divergence histogram
     */
    @category = "MACD"
    @label = "Histogram^{%(timeframe)s}_{%(step)s}(%(x)s)"
    def Histogram(x = .math.macd(),
                  /** signal period */ timeframe = 9.0,
                  /** discretization step */ step = 1.0) = x~>Value-x~>Signal(timeframe,step)
    
    /** Relative standard deviation
     */
    @category = "Statistics"
    def RelStdDev(x = .math.Cumulative()) = (x~>Source-x~>Avg)/x~>StdDev
    
    /** Relative standard deviation
     */
    @category = "Statistics"
    def RelStdDev(x = .math.EW()) = (x~>Source-x~>Avg)/x~>StdDev
    
    /** Relative standard deviation
     */
    @category = "Statistics"
    def RelStdDev(x = .math.Moving()) = (x~>Source-x~>Avg)/x~>StdDev
    
    /** Cumulative variance
     */
    @category = "Statistics"
    @python.intrinsic("moments.cmv.Variance_Impl")
    def Var(x = .math.Cumulative()) : () => .Float
    
    /** Exponentially weighted moving variance
     */
    @category = "Statistics"
    @python.intrinsic("moments.ewmv.EWMV_Impl")
    def Var(x = .math.EW()) : () => .Float
    
    /** Simple moving variance
     */
    @category = "Statistics"
    @python.intrinsic("moments.mv.MV_Impl")
    def Var(x = .math.Moving()) : () => .Float
    
    /** Moving average convergence/divergence signal
     */
    @category = "MACD"
    @label = "Signal^{%(timeframe)s}_{%(step)s}(%(x)s)"
    def Signal(x = .math.macd(),
               /** signal period */ timeframe = 9.0,
               /** discretization step */ step = 1.0) = x~>Value~>OnEveryDt(step)~>EW(2/(timeframe+1))~>Avg
    
    /** Returns negative movements of some observable *source* with lag *timeframe*
     */
    @label = "Downs_{%(timeframe)s}(%(source)s)"
    def DownMovements(/** observable data source */ source = .const(1.0),
                      /** lag size */ timeframe = 10.0) = .math.Max(0.0,source~>Lagged(timeframe)-source)
    
    /** Arc tangent of x, in radians.
     *
     */
    @category = "Trigonometric"
    @python.mathops("atan")
    def Atan(x = .constant(0.0)) : () => .Float
    
    /** Observable that adds a lag to an observable data source
     *  so Lagged(x, dt)(t0+dt) == x(t0)
     */
    @python.intrinsic("observable.lagged.Lagged_Impl")
    @label = "Lagged_{%(timeframe)s}(%(source)s)"
    def Lagged(/** observable data source */ source = .const(1.0),
               /** lag size */ timeframe = 10.0) : .IObservable[.Float]
    
    /** Function returning maximum of two functions *x* and *y*.
     * If *x* or/and *y* are observables, *Min* is also observable
     */
    @python.observable()
    @label = "max{%(x)s, %(y)s}"
    def Max(x = .constant(1.0),
            y = .constant(1.0)) = if x>y then x else y
    
    @category = "RSI"
    def Value(x = .math.RSI()) = 100.0-100.0/(1.0+x~>Raw)
    
    /** Moving average convergence/divergence
     */
    @category = "MACD"
    def Value(x = .math.macd()) = x~>Source~>EW(2.0/(x~>Fast+1))~>Avg-x~>Source~>EW(2.0/(x~>Slow+1))~>Avg
    
    /** Returns positive movements of some observable *source* with lag *timeframe*
     */
    @label = "Ups_{%(timeframe)s}(%(source)s)"
    def UpMovements(/** observable data source */ source = .const(1.0),
                    /** lag size */ timeframe = 10.0) = .math.Max(0.0,source-source~>Lagged(timeframe))
    
    /** Square of *x*
     */
    @category = "Log/Pow"
    @python.observable()
    @label = "{%(x)s}^2"
    def Sqr(x = .constant(1.0)) = x*x
    
    /** Log returns
     */
    @label = "LogReturns_{%(timeframe)s}(%(x)s)"
    def LogReturns(/** observable data source */ x = .const(1.0),
                   /** lag size */ timeframe = 10.0) = .math.Log(x/x~>Lagged(timeframe))
    
    /** Cumulative average
     */
    @category = "Statistics"
    @python.intrinsic("moments.cma.CMA_Impl")
    def Avg(x = .math.Cumulative()) : .IDifferentiable
    
    /** Exponentially weighted moving average
     */
    @category = "Statistics"
    @python.intrinsic("moments.ewma.EWMA_Impl")
    def Avg(x = .math.EW()) : .IDifferentiable
    
    /** Simple moving average
     */
    @category = "Statistics"
    @python.intrinsic("moments.ma.MA_Impl")
    def Avg(x = .math.Moving()) : .IDifferentiable
    
    /** Square root of *x*
     *
     */
    @category = "Log/Pow"
    @python.mathops("sqrt")
    @label = "\\sqrt{%(x)s}"
    def Sqrt(x = .constant(1.0)) : () => .Float
    
    /** Exponent of *x*
     *
     */
    @category = "Log/Pow"
    @python.mathops("exp")
    @label = "e^{%(x)s}"
    def Exp(x = .constant(1.0)) : () => .Float
    
    /** Natural logarithm of *x* (to base e)
     *
     */
    @category = "Log/Pow"
    @python.mathops("log")
    @label = "log(%(x)s)"
    def Log(x = .constant(1.0)) : () => .Float
    
    /** A discrete signal with user-defined increments.
     */
    @python.intrinsic("observable.randomwalk.RandomWalk_Impl")
    @label = "%(name)s"
    def RandomWalk(/** initial value of the signal */ initialValue = 0.0,
                   /** increment function */ deltaDistr = .math.random.normalvariate(0.0,1.0),
                   /** intervals between signal updates */ intervalDistr = .math.random.expovariate(1.0),
                   name = "-random-") : .IObservable[.Float]
    
    /** Cumulative minimum of a function with positive tolerance.
     *
     *  It fires updates only if *source* value becomes less than the old value minus *epsilon*
     */
    @category = "Statistics"
    @python.intrinsic("observable.minmax_eps.MinEpsilon_Impl")
    @label = "Min_{\\epsilon}(%(x)s)"
    def MinEpsilon(x = .math.Cumulative(),
                   epsilon = .constant(0.01)) : .IObservable[.Float]
    
    /** Cumulative maximum of a function with positive tolerance.
     *
     *  It fires updates only if *source* value becomes greater than the old value plus *epsilon*
     */
    @category = "Statistics"
    @python.intrinsic("observable.minmax_eps.MaxEpsilon_Impl")
    @label = "Max_{\\epsilon}(%(x)s)"
    def MaxEpsilon(x = .math.Cumulative(),
                   epsilon = .constant(0.01)) : .IObservable[.Float]
    
    /** Standard deviation
     */
    @category = "Statistics"
    def StdDev(x = .math.Cumulative()) = x~>Var~>Sqrt
    
    /** Standard deviation
     */
    @category = "Statistics"
    def StdDev(x = .math.EW()) = x~>Var~>Sqrt
    
    /** Standard deviation
     */
    @category = "Statistics"
    def StdDev(x = .math.Moving()) = x~>Var~>Sqrt
    
    /** Running maximum of a function
     */
    @category = "Statistics"
    @python.intrinsic("observable.minmax.Max_Impl")
    def Maximum(x = .math.Moving()) : .IObservable[.Float]
    
    /** Function returning first derivative on time of *x*
     * *x* should provide *derivative* member
     */
    @python.intrinsic("observable.derivative.Derivative_Impl")
    @label = "\\frac{d%(x)s}{dt}"
    def Derivative(x = .math.Avg(.math.EW()) : .IDifferentiable) : () => .Float
    
    /** Absolute value for Relative Strength Index
     */
    @category = "RSI"
    def Raw(x = .math.RSI()) = x~>Source~>UpMovements(x~>Timeframe)~>EW(x~>Alpha)~>Avg/x~>Source~>DownMovements(x~>Timeframe)~>EW(x~>Alpha)~>Avg
    
    /** Return *x* raised to the power *y*.
     *
     * Exceptional cases follow Annex F of the C99 standard as far as possible.
     * In particular, ``pow(1.0, x)`` and ``pow(x, 0.0)`` always return 1.0,
     * even when *x* is a zero or a NaN.
     * If both *x* and *y* are finite, *x* is negative, and *y* is not an integer then
     * ``pow(x, y)`` is undefined, and raises ``ValueError``.
     */
    @category = "Log/Pow"
    @python.mathops("pow")
    @label = "%(base)s^{%(power)s}"
    def Pow(base = .constant(1.0),
            power = .constant(1.0)) : () => .Float
    
    /** Running minimum of a function
     */
    @category = "Statistics"
    @python.intrinsic("observable.minmax.Min_Impl")
    def Minimum(x = .math.Moving()) : .IObservable[.Float]
    
}

@category = "Order"
package order
{
    package side
    {
        package price
        {
            def Limit = .order._curried.side_price_Limit
            
            def ImmediateOrCancel = .order._curried.side_price_ImmediateOrCancel
            
            def StopLoss = .order._curried.side_price_StopLoss
            
            def WithExpiry = .order._curried.side_price_WithExpiry
            
            def FloatingPrice = .order._curried.side_price_FloatingPrice
            
            def Iceberg = .order._curried.side_price_Iceberg
            
            def Peg = .order._curried.side_price_Peg
            
        }
        
        def Limit = .order._curried.side_Limit
        
        def ImmediateOrCancel = .order._curried.side_ImmediateOrCancel
        
        def Market = .order._curried.side_Market
        
        def StopLoss = .order._curried.side_StopLoss
        
        def WithExpiry = .order._curried.side_WithExpiry
        
        def FloatingPrice = .order._curried.side_FloatingPrice
        
        def Iceberg = .order._curried.side_Iceberg
        
        def FixedBudget = .order._curried.side_FixedBudget
        
        def Peg = .order._curried.side_Peg
        
    }
    
    package side_price
    {
        def Limit = .order._curried.sideprice_Limit
        
        def ImmediateOrCancel = .order._curried.sideprice_ImmediateOrCancel
        
        def StopLoss = .order._curried.sideprice_StopLoss
        
        def WithExpiry = .order._curried.sideprice_WithExpiry
        
        def FloatingPrice = .order._curried.sideprice_FloatingPrice
        
        def Iceberg = .order._curried.sideprice_Iceberg
        
        def Peg = .order._curried.sideprice_Peg
        
    }
    
    package price
    {
        def Limit = .order._curried.price_Limit
        
        def ImmediateOrCancel = .order._curried.price_ImmediateOrCancel
        
        def StopLoss = .order._curried.price_StopLoss
        
        def WithExpiry = .order._curried.price_WithExpiry
        
        def FloatingPrice = .order._curried.price_FloatingPrice
        
        def Iceberg = .order._curried.price_Iceberg
        
        def Peg = .order._curried.price_Peg
        
    }
    
    package signed
    {
        def Limit = .order.LimitSigned
        
        def Market = .order.MarketSigned
        
    }
    
    package signedVolume
    {
        def LimitSigned = .order._curried.signedVolume_LimitSigned
        
        def MarketSigned = .order._curried.signedVolume_MarketSigned
        
    }
    
    package _curried
    {
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def side_ImmediateOrCancel(/** factory for underlying orders */ proto = .order.side.Limit()) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("price_StopLoss")
        def side_price_StopLoss(/** underlying orders to create */ proto = .order.side.price.Limit(),
                                /** maximal acceptable loss factor */ maxloss = .constant(0.1)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def price_Iceberg(/** underlying orders to create */ proto = .order.price.Limit(),
                          /** maximal size of order to send */ lotSize = .constant(10.0)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def sideprice_FloatingPrice(/** underlying orders to create */ proto = .order.side.price.Limit(),
                                    /** observable defining price of orders to create */ floatingPrice = .const(10.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def price_StopLoss(/** underlying orders to create */ proto = .order.price.Limit(),
                           /** maximal acceptable loss factor */ maxloss = .constant(0.1)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def price_ImmediateOrCancel(/** factory for underlying orders */ proto = .order.price.Limit()) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def sideprice_StopLoss(/** underlying orders to create */ proto = .order.side_price.Limit(),
                               /** maximal acceptable loss factor */ maxloss = .constant(0.1)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def side_Iceberg(/** underlying orders to create */ proto = .order.side.Limit(),
                         /** maximal size of order to send */ lotSize = .constant(10.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating fixed budget orders
         *
         *  Fixed budget order acts like a market order
         *  but the volume is implicitly given by a budget available for trades.
         *  Internally first it sends request.EvalVolumesForBudget
         *  to estimate volumes and prices of orders to sent and
         *  then sends a sequence of order.ImmediateOrCancel to be sure that
         *  cumulative price of trades to be done won't exceed the given budget.
         */
        @python.order.factory.curried("FixedBudget")
        def side_FixedBudget(/** function defining budget on which it may send orders at one time */ budget = .constant(1000.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def sideprice_Limit(/** function defining volume of orders to create */ volume = .constant(1.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def sideprice_Peg(proto = .order.side.price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def side_Peg(proto = .order.side.price.Limit()) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("LimitSigned")
        def signedVolume_LimitSigned(/** function defining price of orders to create */ price = .constant(100.0)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("price_Iceberg")
        def side_price_Iceberg(/** underlying orders to create */ proto = .order.side.price.Limit(),
                               /** maximal size of order to send */ lotSize = .constant(10.0)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("price_ImmediateOrCancel")
        def side_price_ImmediateOrCancel(/** factory for underlying orders */ proto = .order.side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def side_WithExpiry(/** underlying orders to create */ proto = .order.side.Limit(),
                            /** expiration period for orders */ expiry = .constant(10.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def side_StopLoss(/** underlying orders to create */ proto = .order.side.Limit(),
                          /** maximal acceptable loss factor */ maxloss = .constant(0.1)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def price_Peg(proto = .order.price.Limit()) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def sideprice_WithExpiry(/** underlying orders to create */ proto = .order.side_price.Limit(),
                                 /** expiration period for orders */ expiry = .constant(10.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def side_Limit(/** function defining price of orders to create */ price = .constant(100.0),
                       /** function defining volume of orders to create */ volume = .constant(1.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("price_FloatingPrice")
        def side_price_FloatingPrice(/** underlying orders to create */ proto = .order.side.price.Limit(),
                                     /** observable defining price of orders to create */ floatingPrice = .const(10.0)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def side_FloatingPrice(/** underlying orders to create */ proto = .order.side.price.Limit(),
                               /** observable defining price of orders to create */ floatingPrice = .const(10.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("price_WithExpiry")
        def side_price_WithExpiry(/** underlying orders to create */ proto = .order.side.price.Limit(),
                                  /** expiration period for orders */ expiry = .constant(10.0)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("price_Limit")
        def side_price_Limit(/** function defining volume of orders to create */ volume = .constant(1.0)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("Market")
        def side_Market(/** function defining volume of orders to create */ volume = .constant(1.0)) : (() => .Side) => .IOrderGenerator
        
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def price_FloatingPrice(/** underlying orders to create */ proto = .order.price.Limit(),
                                /** observable defining price of orders to create */ floatingPrice = .const(10.0)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def price_WithExpiry(/** underlying orders to create */ proto = .order.price.Limit(),
                             /** expiration period for orders */ expiry = .constant(10.0)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def price_Limit(/** function defining side of orders to create */ side = .side.Sell(),
                        /** function defining volume of orders to create */ volume = .constant(1.0)) : (() => .Float) => .IOrderGenerator
        
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def sideprice_Iceberg(/** underlying orders to create */ proto = .order.side_price.Limit(),
                              /** maximal size of order to send */ lotSize = .constant(10.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("MarketSigned")
        def signedVolume_MarketSigned() : (() => .Float) => .IOrderGenerator
        
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def sideprice_ImmediateOrCancel(/** factory for underlying orders */ proto = .order.side_price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("price_Peg")
        def side_price_Peg(proto = .order.side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
    }
    
    /** Factory creating limit orders
     *
     *  Limit orders ask to buy or sell some asset at price better than some limit price.
     *  If a limit order is not competely fulfilled
     *  it remains in an order book waiting to be matched with another order.
     */
    @python.order.factory("order.limit.Order_Impl")
    def Limit(/** function defining side of orders to create */ side = .side.Sell(),
              /** function defining price of orders to create */ price = .constant(100.0),
              /** function defining volume of orders to create */ volume = .constant(1.0)) : .IOrderGenerator
    
    /** Factory creating market orders
     *
     *  Market order intructs buy or sell given volume immediately
     */
    @python.order.factory("order.market.Order_Impl")
    def MarketSigned(/**signed volume*/ signedVolume : () => .Float = .constant(1.0)) : .IOrderGenerator
    
    /** Factory creating Immediate-Or-Cancel orders
     *
     *  Immediate-Or-Cancel order sends an underlying order to the market and
     *  immediately sends a cancel request for it.
     *  It allows to combine market and limit order behaviour:
     *  the order is either executed immediately
     *  at price equal or better than given one
     *  either it is cancelled (and consequently never stored in the order queue).
     */
    @python.order.factory("order.meta.ioc.Order_Impl")
    def ImmediateOrCancel(/** factory for underlying orders */ proto = .order.Limit()) : .IOrderGenerator
    
    /** Factory creating market orders
     *
     *  Market order intructs buy or sell given volume immediately
     */
    @python.order.factory("order.market.Order_Impl")
    def Market(/** function defining side of orders to create */ side = .side.Sell(),
               /** function defining volume of orders to create */ volume = .constant(1.0)) : .IOrderGenerator
    
    /** Factory creating StopLoss orders
     *
     *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
     *  It keeps track of position and balance change induced by trades of the underlying order and
     *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
     *  the meta order clears its position.
     */
    @python.order.factory("order.meta.stoploss.Order_Impl")
    def StopLoss(/** underlying orders to create */ proto = .order.Limit(),
                 /** maximal acceptable loss factor */ maxloss = .constant(0.1)) : .IOrderGenerator
    
    /** Factory creating WithExpiry orders
     *
     * WithExpiry orders can be viewed as ImmediateOrCancel orders
     * where cancel order is sent not immediately but after some delay
     */
    @python.order.factory("order.meta.with_expiry.Order_Impl")
    def WithExpiry(/** underlying orders to create */ proto = .order.Limit(),
                   /** expiration period for orders */ expiry = .constant(10.0)) : .IOrderGenerator
    
    /** Factory creating orders with floating price
     *
     *  Floating price order is initialized by an order having a price and an observable that generates new prices.
     *  When the observable value changes the order is cancelled and
     *  a new order with new price is created and sent to the order book.
     */
    @python.order.factory("order.meta.floating_price.Factory_Impl")
    def FloatingPrice(/** underlying orders to create */ proto = .order.price.Limit(),
                      /** observable defining price of orders to create */ floatingPrice = .const(10.0)) : .IOrderGenerator
    
    /** Factory creating iceberg orders
     *
     *  Iceberg order is initialized by an underlying order and a lot size.
     *  It sends consequently pieces of the underlying order of size equal or less to the lot size
     *  thus maximum lot size volume is visible at the market at any moment.
     */
    @python.order.factory("order.meta.iceberg.Order_Impl")
    def Iceberg(/** underlying orders to create */ proto = .order.Limit(),
                /** maximal size of order to send */ lotSize = .constant(10.0)) : .IOrderGenerator
    
    /** Factory creating fixed budget orders
     *
     *  Fixed budget order acts like a market order
     *  but the volume is implicitly given by a budget available for trades.
     *  Internally first it sends request.EvalVolumesForBudget
     *  to estimate volumes and prices of orders to sent and
     *  then sends a sequence of order.ImmediateOrCancel to be sure that
     *  cumulative price of trades to be done won't exceed the given budget.
     */
    @python.order.factory("order.meta.fixed_budget.Order_Impl")
    def FixedBudget(/** function defining side of orders to create */ side = .side.Sell(),
                    /** function defining budget on which it may send orders at one time */ budget = .constant(1000.0)) : .IOrderGenerator
    
    /** Factory creating limit orders
     *
     *  Limit orders ask to buy or sell some asset at price better than some limit price.
     *  If a limit order is not competely fulfilled
     *  it remains in an order book waiting to be matched with another order.
     */
    @python.order.factory("order.limit.Order_Impl")
    def LimitSigned(/**signed volume*/ signedVolume : () => .Float = .constant(1.0),
                    /** function defining price of orders to create */ price = .constant(100.0)) : .IOrderGenerator
    
    /** Factory creating Peg orders
     *
     *  A peg order is a particular case of the floating price order
     *  with the price better at one tick than the best price of the order queue.
     *  It implies that if several peg orders are sent to the same order queue
     *  they start to race until being matched against the counterparty orders.
     */
    @python.order.factory("order.meta.peg.Factory_Impl")
    def Peg(proto = .order.price.Limit()) : .IOrderGenerator
    
}

@category = "Strategy"
package strategy
{
    @category = "Side function"
    package side
    {
        type PairTrading(/** reference to order book for another asset
          * used to evaluate fair price of our asset */ bookToDependOn = .orderbook.OfTrader(),/** multiplier to obtain fair asset price from the reference asset price */ factor = 1.0) : FundamentalValueStrategy
        
        type Signal(/** signal to be listened to */ source = .constant(0.0),/** threshold when the trader starts to act */ threshold = 0.7) : SignalStrategy
        
        type CrossingAverages(/** parameter |alpha| for exponentially weighted moving average 1 */ alpha_1 = 0.15,/** parameter |alpha| for exponentially weighted moving average 2 */ alpha_2 = 0.015,/** threshold when the trader starts to act */ threshold = 0.0,/** asset in question */ book = .orderbook.OfTrader()) : SignalStrategy
        
        abstract type SideStrategy
        
        type TrendFollower(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.15,/** threshold when the trader starts to act */ threshold = 0.0,/** asset in question */ book = .orderbook.OfTrader()) : SignalStrategy
        
        type FundamentalValue(/** observable fundamental value */ fv = .constant(200.0)) : FundamentalValueStrategy
        
        type RSIbis(/** parameter |alpha| for exponentially weighted moving average when calculating RSI */ alpha = 1.0/14,/** lag for calculating up and down movements for RSI */ timeframe = 1.0,/** strategy starts to act once RSI is out of [50-threshold, 50+threshold] */ threshold = 30.0) : SignalStrategy
        
        abstract type FundamentalValueStrategy() : SideStrategy
        
        type MeanReversion(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.15) : FundamentalValueStrategy
        
        abstract type SignalStrategy() : SideStrategy
        
        type Noise(side_distribution = math.random.uniform(0.0,1.0)) : SideStrategy
        
        def Fundamental_Value(x = .strategy.side.MeanReversion()) = x~>book~>MidPrice~>EW(x~>Alpha)~>Avg
        
        def Fundamental_Value(x = .strategy.side.FundamentalValue()) = x~>Fv
        
        def Fundamental_Value(x = .strategy.side.PairTrading()) = x~>BookToDependOn~>MidPrice*x~>Factor
        
        def book(x = .strategy.side.MeanReversion()) = .orderbook.OfTrader()
        
        def book(x = .strategy.side.FundamentalValue()) = .orderbook.OfTrader()
        
        def book(x = .strategy.side.PairTrading()) = .orderbook.OfTrader()
        
        def Side(x = .strategy.side.Noise()) = if x~>Side_distribution>0.5 then .side.Buy() else .side.Sell()
        
        def Side(x = .strategy.side.MeanReversion()) = if x~>book~>Bids~>BestPrice>x~>Fundamental_Value then .side.Sell() else if x~>book~>Asks~>BestPrice<x~>Fundamental_Value then .side.Buy() else .side.Nothing()
        
        def Side(x = .strategy.side.RSIbis()) = if x~>Signal_Value>x~>Threshold then .side.Buy() else if x~>Signal_Value<0-x~>Threshold then .side.Sell() else .side.Nothing()
        
        def Side(x = .strategy.side.FundamentalValue()) = if x~>book~>Bids~>BestPrice>x~>Fundamental_Value then .side.Sell() else if x~>book~>Asks~>BestPrice<x~>Fundamental_Value then .side.Buy() else .side.Nothing()
        
        def Side(x = .strategy.side.TrendFollower()) = if x~>Signal_Value>x~>Threshold then .side.Buy() else if x~>Signal_Value<0-x~>Threshold then .side.Sell() else .side.Nothing()
        
        def Side(x = .strategy.side.CrossingAverages()) = if x~>Signal_Value>x~>Threshold then .side.Buy() else if x~>Signal_Value<0-x~>Threshold then .side.Sell() else .side.Nothing()
        
        def Side(x = .strategy.side.Signal()) = if x~>Signal_Value>x~>Threshold then .side.Buy() else if x~>Signal_Value<0-x~>Threshold then .side.Sell() else .side.Nothing()
        
        def Side(x = .strategy.side.PairTrading()) = if x~>book~>Bids~>BestPrice>x~>Fundamental_Value then .side.Sell() else if x~>book~>Asks~>BestPrice<x~>Fundamental_Value then .side.Buy() else .side.Nothing()
        
        def Strategy(x = .strategy.side.Noise(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.MeanReversion(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.RSIbis(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.FundamentalValue(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.TrendFollower(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.CrossingAverages(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.Signal(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Strategy(x = .strategy.side.PairTrading(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side.Market()) = .strategy.Generic(orderFactory(x~>Side),eventGen)
        
        def Signal_Value(x = .strategy.side.RSIbis()) = 50.0-.orderbook.OfTrader()~>MidPrice~>RSI(x~>Timeframe,x~>Alpha)~>Value
        
        def Signal_Value(x = .strategy.side.TrendFollower()) = x~>Book~>MidPrice~>EW(x~>Alpha)~>Avg~>Derivative
        
        def Signal_Value(x = .strategy.side.CrossingAverages()) = x~>Book~>MidPrice~>EW(x~>Alpha_1)~>Avg-x~>Book~>MidPrice~>EW(x~>Alpha_2)~>Avg
        
        def Signal_Value(x = .strategy.side.Signal()) = x~>Source
        
    }
    
    package weight
    {
        package array
        {
            /** Function returning an array of length *len(array)*
             *  having 1 at the index of the maximal element and 0 are at the rest
             */
            @python.curried("ChooseTheBest")
            def array_ChooseTheBest() : .Optional[.List[.Float]] => .IFunction[.List[.Float]]
            
            /** Identity function for an array of floats
             */
            @python.curried("IdentityL")
            def array_IdentityL() : .Optional[.List[.Float]] => .IFunction[.List[.Float]]
            
        }
        
        package trader
        {
            /** Calculates how many times efficiency of trader went up and went down
             * Returns difference between them.
             *
             * TODO: should be UpScore(timeframe, Efficiency(trader)) - DownScore(timeframe, Efficiency(trader))
             */
            @python.curried("Score")
            def trader_Score() : .IAccount => .IFunction[.Float]
            
            /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
             */
            @python.curried("TraderEfficiency")
            def trader_TraderEfficiency() : .IAccount => .IFunction[.Float]
            
            /** Unit function. Used to simulate uniform random choice of a strategy
             */
            @python.curried("Unit")
            def trader_Unit() : .IAccount => .IFunction[.Float]
            
            /** Returns first derivative of a moving average of the trader efficiency
             */
            @python.curried("TraderEfficiencyTrend")
            def trader_TraderEfficiencyTrend(/** parameter alpha for the moving average */ alpha = 0.15) : .IAccount => .IFunction[.Float]
            
        }
        
        package f
        {
            /** scaling function = max(0, f(x)) + 1
             */
            @python.curried("Clamp0")
            def f_Clamp0() : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
            /** scaling function = atan(base^f(x))
             */
            @python.curried("AtanPow")
            def f_AtanPow(/** base for power function */ base = 1.002) : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
            /** identity scaling = f(x)
             */
            @python.curried("IdentityF")
            def f_IdentityF() : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
        }
        
        def efficiency = .strategy.weight.trader.trader_TraderEfficiency
        
        /** Function returning an array of length *len(array)*
         *  having 1 at the index of the maximal element and 0 are at the rest
         */
        @python.intrinsic("strategy.weight.ChooseTheBest_Impl")
        @curried("array")
        def ChooseTheBest(array : .Optional[.List[.Float]] = []) : .IFunction[.List[.Float]]
        
        def chooseTheBest = .strategy.weight.array.array_ChooseTheBest
        
        def score = .strategy.weight.trader.trader_Score
        
        def identityL = .strategy.weight.array.array_IdentityL
        
        def efficiencyTrend = .strategy.weight.trader.trader_TraderEfficiencyTrend
        
        def clamp0 = .strategy.weight.f.f_Clamp0
        
        /** Calculates how many times efficiency of trader went up and went down
         * Returns difference between them.
         *
         * TODO: should be UpScore(timeframe, Efficiency(trader)) - DownScore(timeframe, Efficiency(trader))
         */
        @python.intrinsic("strategy.weight.Score_Impl")
        @curried("trader")
        def Score(/** account in question */ trader : .IAccount = .trader.SingleProxy()) : .IFunction[.Float]
        
        /** scaling function = max(0, f(x)) + 1
         */
        @curried("f")
        def Clamp0(/** function to scale */ f : .Optional[.IFunction[.Float]] = .constant(1.0)) : .IFunction[.Float] = .math.Max(0,f)+1
        
        def identityF = .strategy.weight.f.f_IdentityF
        
        def atanPow = .strategy.weight.f.f_AtanPow
        
        def unit = .strategy.weight.trader.trader_Unit
        
        /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
         */
        @curried("trader")
        def TraderEfficiency(/** account in question */ trader : .IAccount = .trader.SingleProxy()) : .IFunction[.Float] = trader~>Efficiency
        
        /** Unit function. Used to simulate uniform random choice of a strategy
         */
        @curried("trader")
        def Unit(/** account in question */ trader : .IAccount = .trader.SingleProxy()) : .IFunction[.Float] = .constant(1.0)
        
        /** scaling function = atan(base^f(x))
         */
        @curried("f")
        def AtanPow(/** function to scale */ f : .Optional[.IFunction[.Float]] = .constant(1.0),
                    /** base for power function */ base = 1.002) : .IFunction[.Float] = .const(base)~>Pow(f)~>Atan
        
        /** Identity function for an array of floats
         */
        @python.intrinsic("strategy.weight.Identity_Impl")
        @curried("array")
        def IdentityL(array : .Optional[.List[.Float]] = []) : .IFunction[.List[.Float]]
        
        /** identity scaling = f(x)
         */
        @curried("f")
        def IdentityF(f : .Optional[.IFunction[.Float]] = .constant(1.0)) : .IFunction[.Float] = f
        
        /** Returns first derivative of a moving average of the trader efficiency
         */
        @curried("trader")
        def TraderEfficiencyTrend(/** account in question */ trader : .IAccount = .trader.SingleProxy(),
                                  /** parameter alpha for the moving average */ alpha = 0.15) : .IFunction[.Float] = trader~>EfficiencyTrend(alpha)
        
    }
    
    @category = "Price function"
    package price
    {
        type LiquidityProvider(/** initial price which is taken if orderBook is empty */ initialValue = 100.0,/** defines multipliers for current asset price when price of
          *             order to create is calculated*/ priceDistr = .math.random.lognormvariate(0.0,0.1),/** asset in question */ book = .orderbook.OfTrader())
        
        type MarketData(/** Ticker of the asset */ ticker = "^GSPC",/** Start date in DD-MM-YYYY format */ start = "2001-1-1",/** End date in DD-MM-YYYY format */ end = "2010-1-1",/** Price difference between orders placed and underlying quotes */ delta = 1.0,/** Volume of Buy/Sell orders. Should be large compared to the volumes of other traders. */ volume = 1000.0)
        
        type MarketMaker(delta = 1.0,volume = 20.0)
        
        def TwoSides(x = .strategy.price.MarketMaker()) = .strategy.Combine(x~>OneSide(.side.Sell(),1.0),x~>OneSide(.side.Buy(),-1.0))
        
        def TwoSides(x = .strategy.price.MarketData()) = .strategy.Combine(x~>OneSide(.side.Sell(),1.0),x~>OneSide(.side.Buy(),-1.0))
        
        @python.intrinsic("strategy.ladder.OneSide_Impl")
        def Ladder(orderFactory = .order.side_price.Limit(),
                   initialSize = 10,
                   side = .side.Sell()) : .ISingleAssetStrategy
        
        def OneSide(x = .strategy.price.MarketMaker(),
                    side = .side.Sell(),
                    sign = 1.0) = .order.price.Limit(side,x~>Volume*1000)~>FloatingPrice(.orderbook.OfTrader()~>Queue(side)~>SafeSidePrice(100+x~>Delta*sign)/.trader.Position()~>Atan/1000~>Exp~>OnEveryDt(0.9)~>BreaksAtChanges)~>Iceberg(x~>Volume)~>Strategy(.event.After(0.0))
        
        def OneSide(x = .strategy.price.MarketData(),
                    side = .side.Sell(),
                    sign = 1.0) = .order.price.Limit(side,x~>Volume*1000)~>FloatingPrice(x~>Ticker~>Quote(x~>Start,x~>End)+x~>Delta*sign~>BreaksAtChanges)~>Iceberg(x~>Volume)~>Strategy(.event.After(0.0))
        
        def Price(x = .strategy.price.LiquidityProvider(),
                  side = .side.Sell() : .IFunction[.Side]) = x~>Book~>Queue(side)~>SafeSidePrice(x~>InitialValue)*x~>PriceDistr
        
        def Strategy(x = .strategy.price.LiquidityProvider(),
                     /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = .order.side_price.Limit()) = .strategy.Combine(x~>OneSideStrategy(eventGen,orderFactory,.side.Sell()),x~>OneSideStrategy(eventGen,orderFactory,.side.Buy()))
        
        def StopLoss(inner = .strategy.price.LadderMM() : .ISuspendableStrategy,
                     lossFactor = .constant(0.2)) = .strategy.price.Clearable(inner,.strategy.price.isLossTooHigh(lossFactor))
        
        @python.intrinsic("strategy.ladder.Suspend_Impl")
        def Suspend(inner = .strategy.price.LadderMM() : .ISuspendableStrategy,
                    predicate = .false()) : .ISuspendableStrategy
        
        def isLossTooHigh(lossFactor = .constant(0.2)) = if .trader.Position()>0 then .trader.PerSharePrice()>.orderbook.Asks()~>BestPrice/(1-lossFactor) else if .trader.Position()<0 then .trader.PerSharePrice()<.orderbook.Bids()~>BestPrice*(1-lossFactor) else .false()
        
        def OneSideStrategy(x = .strategy.price.LiquidityProvider(),
                            /** Event source making the strategy to wake up*/ eventGen = .event.Every(.math.random.expovariate(1.0)),
                            /** order factory function*/ orderFactory = .order.side_price.Limit(),
                            /** side of orders to create */ side = .side.Sell()) = orderFactory(side,x~>Price(side))~>Strategy(eventGen)
        
        @python.intrinsic("strategy.ladder.MarketMaker_Impl")
        def LadderMM(orderFactory = .order.side_price.Limit(),
                     initialSize = 10) : .ILadderStrategy
        
        @python.intrinsic("strategy.ladder.Balancer_Impl")
        def LadderBalancer(inner = .strategy.price.LadderMM(),
                           maximalSize = 20) : .ILadderStrategy
        
        @python.intrinsic("strategy.ladder.Clearable_Impl")
        def Clearable(inner = .strategy.price.LadderMM() : .ISuspendableStrategy,
                      predicate = .false()) : .ISuspendableStrategy
        
    }
    
    @category = "Volume function"
    package position
    {
        abstract type DesiredPositionStrategy
        
        type Bollinger_linear(/** alpha parameter for exponentially weighted
          * moving everage and variance */ alpha = 0.15,/** observable scaling function that maps
          * relative deviation to desired position */ k = .const(0.5),/** trader in question */ trader = .trader.SingleProxy()) : DesiredPositionStrategy
        
        type RSI_linear(/** alpha parameter for exponentially moving averages of up movements and down movements */ alpha = 1.0/14.0,/** observable scaling function that maps RSI deviation from 50 to the desired position */ k = .const(-0.04),/** lag for calculating up and down movements */ timeframe = 1.0,/** trader in question */ trader = .trader.SingleProxy()) : DesiredPositionStrategy
        
        def Position(x = .strategy.position.RSI_linear()) = x~>DesiredPosition-x~>Trader~>Position-x~>Trader~>PendingVolume
        
        def Position(x = .strategy.position.Bollinger_linear()) = x~>DesiredPosition-x~>Trader~>Position-x~>Trader~>PendingVolume
        
        def Strategy(x = .strategy.position.RSI_linear(),
                     /** order factory function */ orderFactory = .order.signedVolume.MarketSigned()) = orderFactory(x~>Position)~>Strategy
        
        def Strategy(x = .strategy.position.Bollinger_linear(),
                     /** order factory function */ orderFactory = .order.signedVolume.MarketSigned()) = orderFactory(x~>Position)~>Strategy
        
        def DesiredPosition(x = .strategy.position.RSI_linear()) = (50.0-x~>Trader~>Orderbook~>MidPrice~>RSI(x~>Timeframe,x~>Alpha)~>Value~>OnEveryDt(1.0))*x~>K
        
        def DesiredPosition(x = .strategy.position.Bollinger_linear()) = x~>Trader~>Orderbook~>MidPrice~>EW(x~>Alpha)~>RelStdDev~>OnEveryDt(1.0)*x~>K
        
    }
    
    package account
    {
        package inner
        {
            /** Associated with a strategy account that tracks
             *  how orders sent by the strategy have been actually traded
             */
            @python.curried("Real")
            def inner_Real() : .Optional[.ISingleAssetStrategy] => .IAccount
            
            /** Associated with a strategy account that evaluates for every order sent by the strategy
             *  how it would be traded by sending request.evalMarketOrder
             *  (note: orders sent by a strategy wrapped into an adaptive strategy may not come to the market
             *  but we want evaluate in any case would it be profitable or not)
             */
            @python.curried("VirtualMarket")
            def inner_VirtualMarket() : .Optional[.ISingleAssetStrategy] => .IAccount
            
        }
        
        /** Associated with a strategy account that tracks
         *  how orders sent by the strategy have been actually traded
         */
        @python.intrinsic("strategy.account.Account_Impl")
        @curried("inner")
        def Real(/** strategy to track */ inner : .Optional[.ISingleAssetStrategy] = .strategy.Empty()) : .IAccount
        
        /** Associated with a strategy account that evaluates for every order sent by the strategy
         *  how it would be traded by sending request.evalMarketOrder
         *  (note: orders sent by a strategy wrapped into an adaptive strategy may not come to the market
         *  but we want evaluate in any case would it be profitable or not)
         */
        @python.intrinsic("strategy.account.VirtualMarket_Impl")
        @curried("inner")
        def VirtualMarket(/** strategy to track */ inner : .Optional[.ISingleAssetStrategy] = .strategy.Empty()) : .IAccount
        
        def real = .strategy.account.inner.inner_Real
        
        def virtualMarket = .strategy.account.inner.inner_VirtualMarket
        
    }
    
    /** Creates a strategy combining two strategies
     *  Can be considered as a particular case of Array strategy
     */
    @python.intrinsic("strategy.combine.Combine_Impl")
    def Combine(A = .strategy.Empty(),
                B = .strategy.Empty()) : .ISingleAssetStrategy
    
    /** A composite strategy initialized with an array of strategies.
     * In some moments of time the most effective strategy
     * is chosen and made running; other strategies are suspended.
     * It can be considered as a particular case for MultiArmedBandit strategy with
     * *corrector* parameter set to *chooseTheBest*
     */
    @python.intrinsic("strategy.choose_the_best.ChooseTheBest_Impl")
    def ChooseTheBest(/** original strategies that can be suspended */ strategies = [.strategy.Empty()],
                      /** function creating phantom strategy used for efficiency estimation */ account = .strategy.account.virtualMarket(),
                      /** function estimating is the strategy efficient or not */ performance = .strategy.weight.efficiencyTrend()) : .ISingleAssetStrategy
    
    /** Strategy that wraps another strategy and passes its orders only if *predicate* is true
     */
    @python.intrinsic("strategy.suspendable.Suspendable_Impl")
    def Suspendable(/** wrapped strategy */ inner = .strategy.Empty(),
                    /** predicate to evaluate */ predicate = .true()) : .ISingleAssetStrategy
    
    /** Strategy for a multi asset trader.
     * It believes that these assets represent a single asset traded on different venues
     * Once an ask at one venue becomes lower than a bid at another venue
     * it sends market sell and buy orders in order to exploit this arbitrage possibility
     */
    @python.intrinsic("strategy.arbitrage.Arbitrage_Impl")
    def Arbitrage() : .IMultiAssetStrategy
    
    /** Adaptive strategy that evaluates *inner* strategy efficiency
     *  and if it is considered as good, sends orders
     */
    def TradeIfProfitable(/** wrapped strategy */ inner = .strategy.Empty(),
                          /** defines how strategy trades are booked:
                            * actually traded amount or virtual market orders are
                            * used in order to estimate how the strategy would have traded
                            * if all its orders appeared at market */ account = .strategy.account.virtualMarket(),
                          /** given a trading account tells
                            * should it be considered as effective or not */ performance = .strategy.weight.efficiencyTrend()) = inner~>Suspendable(performance(account(inner))>=0)
    
    /** Creates a strategy combining an array of strategies
     */
    @python.intrinsic("strategy.combine.Array_Impl")
    def Array(/** strategies to combine */ strategies = [.strategy.Empty()]) : .ISingleAssetStrategy
    
    /** Empty strategy doing nothing
     */
    @python.intrinsic("strategy.basic.Empty_Impl")
    def Empty() : .ISingleAssetStrategy
    
    /** A composite strategy initialized with an array of strategies.
     * In some moments of time the efficiency of the strategies is evaluated
     * These efficiencies are mapped into weights using *weight* and *normilizer*
     * functions per every strategy and *corrector* for the whole collection of weights
     * These weights are used to choose randomly a strategy to run for the next quant of time.
     * All other strategies are suspended
     */
    @python.intrinsic("strategy.multiarmed_bandit.MultiarmedBandit2_Impl")
    def MultiArmedBandit(/** original strategies that can be suspended */ strategies = [.strategy.Empty()],
                         /** function creating a virtual account used
                           * to estimate efficiency of the strategy itself */ account = .strategy.account.virtualMarket(),
                         /** function estimating is the strategy efficient or not */ weight = .strategy.weight.efficiencyTrend(),
                         /** function that maps trader efficiency to its weight
                           * that will be used for random choice */ normalizer = .strategy.weight.atanPow(),
                         /** given array of strategy weights corrects them.
                           * for example it may set to 0 all weights except the maximal one */ corrector = .strategy.weight.identityL()) : .ISingleAssetStrategy
    
    /** Strategy that listens to all orders sent by a trader to the market
     *  and in some moments of time it randomly chooses an order and cancels it
     *  Note: a similar effect can be obtained using order.WithExpiry meta orders
     */
    @python.intrinsic("strategy.canceller.Canceller_Impl")
    def Canceller(/** intervals between order cancellations */ cancellationIntervalDistr = .math.random.expovariate(1.0)) : .ISingleAssetStrategy
    
    /** Generic strategy that wakes up on events given by *eventGen*,
     *  creates an order via *orderFactory* and sends the order to the market using its trader
     */
    @python.intrinsic("strategy.generic.Generic_Impl")
    @method = "Strategy"
    def Generic(/** order factory function*/ orderFactory = .order.Limit(),
                /** Event source making the strategy to wake up*/ eventGen = .event.Every()) : .ISingleAssetStrategy
    
}

@category = "N/A"
package js
{
    /** Graph to render at Veusz. Time series are added to it automatically in their constructor
     */
    @python.intrinsic("js.Graph_Impl")
    @label = "%(name)s"
    def Graph(name = "graph") : .IGraph
    
}

@category = "Trader"
package trader
{
    /** Number of money owned by trader
     */
    @python.intrinsic("trader.props.Balance_Impl")
    def Balance(trader = .trader.SingleProxy() : .IAccount) : .IObservable[.Price]
    
    @python.intrinsic("trader.props.OnOrderMatched_Impl")
    def OnOrderMatched(trader = .trader.SingleProxy() : .IAccount) : .IEvent
    
    /** Returns traders naive approximation of trader eficiency.
     *  It takes into account only the best price of the order queue
     */
    def RoughPnL(trader = .trader.SingleProxy() : .IAccount) = trader~>Balance+trader~>Orderbook~>NaiveCumulativePrice(trader~>Position)
    
    /** Returns position of the trader
     *  It is negative if trader has sold more assets than has bought and
     *  positive otherwise
     */
    @python.intrinsic("trader.props.Position_Impl")
    def Position(trader = .trader.SingleProxy() : .IAccount) : .IObservable[.Volume]
    
    /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
     */
    def Efficiency(trader = .trader.SingleProxy() : .IAccount) = trader~>Balance+trader~>Orderbook~>CumulativePrice(trader~>Position)
    
    /** Phantom trader that is used to refer to the current trader
     *  (normally it is used to define trader properties and strategies)
     */
    @python.intrinsic("trader.proxy.Single_Impl")
    @label = "N/A"
    def SingleProxy() : .ISingleAssetTrader
    
    /** A trader that trades different assets
     *  It can be considered as a composition of single asset traders and multi asset strategies
     *  At the moment there is no way to instruct a multi asset strategy to trade only on subset of the assets
     */
    @python.intrinsic("trader.classes.MultiAsset_Impl")
    @label = "%(name)s"
    def MultiAsset(/** defines accounts for every asset to trade */ traders = [] : .List[.ISingleAssetTrader],
                   /** multi asset strategy run by the trader */ strategy = .strategy.Arbitrage(),
                   name = "-trader-",
                   /** current trader balance (number of money units that it owns) */ PnL = 0.0,
                   /** defines what data should be gathered for the trader */ timeseries = [] : .List[.ITimeSerie]) : .ITrader
    
    /** Returns first derivative of a moving average of the trader efficiency
     */
    def EfficiencyTrend(trader = .trader.SingleProxy() : .IAccount,
                        alpha = 0.15) = trader~>Efficiency~>EW(alpha)~>Avg~>Derivative
    
    /** Cumulative volume of orders sent to the market but haven't matched yet
     */
    @python.intrinsic("trader.props.PendingVolume_Impl")
    def PendingVolume(trader = .trader.SingleProxy() : .IAccount) : .IObservable[.Volume]
    
    def PerSharePrice(trader = .trader.SingleProxy() : .IAccount) = 0-trader~>Balance/trader~>Position
    
    @python.intrinsic("trader.props.OnTraded_Impl")
    def OnTraded(trader = .trader.SingleProxy() : .IAccount) : .IEvent
    
    /** A trader that trades a single asset on a single market
     */
    @python.intrinsic("trader.classes.SingleAsset_Impl")
    @label = "%(name)s"
    def SingleAsset(/** order book for the asset being traded */ orderBook : .IOrderBook,
                    /** strategy run by the trader */ strategy = .strategy.Empty(),
                    name = "-trader-",
                    /** current position of the trader (number of assets that it owns) */ amount = 0.0,
                    /** current trader balance (number of money units that it owns) */ PnL = 0.0,
                    /** defines what data should be gathered for the trader */ timeseries = [] : .List[.ITimeSerie]) : .ISingleAssetTrader
    
}

@category = "Asset"
package orderbook
{
    type IOrderQueueImpl
    
    /** Phantom orderbook that is used to refer to the current order book
     *
     *  May be used only in objects held by orderbooks (so it is normally used in orderbook properties)
     */
    @python.intrinsic("orderbook.of_trader.Proxy_Impl")
    @label = "N/A"
    def Proxy() : .IOrderBook
    
    @python.intrinsic("orderbook.queue.LastTrade_Impl")
    def LastTradeImpl() : .Any
    
    /** Returns best price if defined, otherwise last price
     *  and *defaultValue* if there haven't been any trades
     */
    @python.observable()
    def SafeSidePrice(queue = .orderbook.Asks(),
                      /** price to be used if there haven't been any trades */ defaultValue = .constant(100.0)) = queue~>BestPrice~>getOrElse(queue~>LastPrice~>getOrElse(defaultValue))
    
    /** Returns moving average of trade prices weighted by their volumes
     */
    @label = "Price_{%(alpha)s}^{%(queue)s}"
    def WeightedPrice(queue = .orderbook.Asks(),
                      /** parameter alpha for the moving average  */ alpha = 0.15) = queue~>LastTradePrice*queue~>LastTradeVolume~>EW(alpha)~>Avg/queue~>LastTradeVolume~>EW(alpha)~>Avg
    
    /** Returns tick size for the order *book*
     */
    @python.intrinsic("orderbook.props.TickSize_Impl")
    def TickSize(book = .orderbook.OfTrader()) : () => .Price
    
    @python.intrinsic("orderbook.queue.BestPrice_Impl")
    def BestPriceImpl(queue : .orderbook.IOrderQueueImpl) : .IObservable[.Price]
    
    /** MidPrice of order *book*
     */
    def MidPrice(book = .orderbook.OfTrader()) = (book~>Asks~>BestPrice+book~>Bids~>BestPrice)/2.0
    
    /** Returns sell side order queue for *book*
     */
    @python.intrinsic("orderbook.proxy.Asks_Impl")
    def Asks(book = .orderbook.OfTrader()) = .orderbook.Queue(book,.side.Sell())
    
    /** Returns volume of the last trade at *queue*
     *  Returns None if there haven't been any trades
     */
    @python.intrinsic("orderbook.last_trade.LastTradeVolume_Impl")
    def LastTradeVolume(queue = .orderbook.Asks()) : .IObservable[.Volume]
    
    /** Returns buy side order queue for *book*
     */
    @python.intrinsic("orderbook.proxy.Bids_Impl")
    def Bids(book = .orderbook.OfTrader()) = .orderbook.Queue(book,.side.Buy())
    
    /** Returns best order price of *queue*
     *  Returns None is *queue* is empty
     */
    @python.intrinsic("orderbook.props.BestPrice_Impl")
    def BestPrice(queue = .orderbook.Asks()) : .IObservable[.Price]
    
    /** Represents latency in information propagation between two agents
     * (normally between a trader and a market).
     * Ensures that sending packets via links preserves their order.
     * Holds two one-way links in opposite directions.
     */
    @python.intrinsic("orderbook.link.TwoWayLink_Impl")
    def TwoWayLink(/** Forward link (normally from a trader to a market)*/ up = .orderbook.Link(),
                   /** Backward link (normally from a market to a trader)*/ down = .orderbook.Link()) : .ITwoWayLink
    
    @python.intrinsic("orderbook.local.Bids_Impl")
    @label = "N/A"
    def BidsImpl(tickSize : .Float,
                 book : .IOrderBook) : .orderbook.IOrderQueueImpl
    
    /** Returns order queue of order *book* for trade *side*
     */
    @python.intrinsic("orderbook.proxy.Queue_Impl")
    def Queue(book = .orderbook.OfTrader(),
              side = .side.Sell()) : .IOrderQueue
    
    /** Phantom orderbook used to refer to the order book associated with a single asset trader
     *
     *  May be used only in objects that are held by traders (so it is used in trader properties and strategies)
     */
    @python.intrinsic("orderbook.of_trader.OfTrader_Impl")
    @label = "N/A"
    @method = "Orderbook"
    def OfTrader(Trader = .trader.SingleProxy() : .IAccount) : .IOrderBook
    
    /** Returns price for best orders of total volume *depth*
     *
     *  In other words cumulative price corresponds to trader balance change
     *  if a market order of volume *depth* is completely matched
     *
     *  Negative *depth* correponds to will buy assets
     *  Positive *depth* correponds to will sell assets
     */
    @python.intrinsic("orderbook.cumulative_price.CumulativePrice_Impl")
    def CumulativePrice(book = .orderbook.OfTrader(),
                        depth = .constant(1.0)) : .IObservable[.Price]
    
    @python.intrinsic("orderbook.remote.Queue_Impl")
    @label = "N/A"
    def RemoteQueueImpl(queue : .orderbook.IOrderQueueImpl,
                        book : .IOrderBook,
                        link : .ILink) : .orderbook.IOrderQueueImpl
    
    /** Returns arrays of levels for given volumes [i*volumeDelta for i in range(0, volumeCount)]
     *  Level of volume V is a price at which cumulative volume of better orders is V
     */
    @python.intrinsic("orderbook.volume_levels.VolumeLevels_Impl")
    @label = "VolumeLevels(%(queue)s)"
    def VolumeLevels(queue = .orderbook.Asks(),
                     /** distance between two volumes */ volumeDelta = 30.0,
                     /** number of volume levels to track */ volumeCount = 10) : .IObservable[.IVolumeLevels]
    
    /** Returns last defined price at *queue*
     *  Returns None is *queue* has been always empty
     */
    @python.intrinsic("orderbook.last_price.LastPrice_Impl")
    def LastPrice(queue = .orderbook.Asks()) : .IObservable[.Price]
    
    @python.intrinsic("orderbook.local.Asks_Impl")
    @label = "N/A"
    def AsksImpl(tickSize : .Float,
                 book : .IOrderBook) : .orderbook.IOrderQueueImpl
    
    /** Order book for a single asset in a market.
     * Maintains two order queues for orders of different sides
     */
    @python.intrinsic("orderbook.local.Local_Impl")
    @label = "%(name)s"
    def Local(name = "-orderbook-",
              tickSize = 0.01,
              _digitsToShow = 2,
              timeseries = [] : .List[.ITimeSerie]) : .IOrderBook
    
    /** Represent an *orderbook* from point of view of a remote trader connected
     * to the market by means of a *link* that introduces some latency in information propagation
     */
    @python.intrinsic("orderbook.remote.Remote_Impl")
    @label = "%(orderbook)s.name^remote"
    def Remote(orderbook = .orderbook.Local(),
               link = .orderbook.TwoWayLink(),
               timeseries = [] : .List[.ITimeSerie]) : .IOrderBook
    
    /** Returns naive approximation of price for best orders of total volume *depth*
     *  by taking into account prices only for the best order
     *
     *  Negative *depth* correponds to will buy assets
     *  Positive *depth* correponds to will sell assets
     */
    def NaiveCumulativePrice(book = .orderbook.OfTrader(),
                             depth = .constant(1.0)) = if depth<0.0 then depth*book~>Asks~>BestPrice else if depth>0.0 then depth*book~>Bids~>BestPrice else 0.0
    
    /** Represents latency in information propagation from one agent to another one
     * (normally between a trader and a market).
     * Ensures that sending packets via a link preserves their order.
     */
    @python.intrinsic("orderbook.link.Link_Impl")
    def Link(/** function called for each packet in order to determine
               * when it will appear at the end point*/ latency = .const(0.001)) : .ILink
    
    /** Spread of order *book*
     */
    def Spread(book = .orderbook.OfTrader()) = book~>Asks~>BestPrice-book~>Bids~>BestPrice
    
    /** Returns price of the last trade at *queue*
     *  Returns None if there haven't been any trades
     */
    @python.intrinsic("orderbook.last_trade.LastTradePrice_Impl")
    def LastTradePrice(queue = .orderbook.Asks()) : .IObservable[.Price]
    
}

@category = "Basic"
package observable
{
    /** Discretizes function *x* at even time steps *dt*
     */
    @python.intrinsic("observable.on_every_dt.OnEveryDt_Impl")
    @label = "[%(x)s]_dt=%(dt)s"
    @observe_args = "no"
    def OnEveryDt(/** function to discretize */ x = .constant(1.0),
                  /** time discretization step */ dt = 1.0) : .IObservable[.Float]
    
    /** Observable that downloads closing prices for every day from *start* to *end* for asset given by *ticker*
     *  and follows the price in scale 1 model unit of time = 1 real day
     */
    @python.intrinsic("observable.quote.Quote_Impl")
    @label = "%(ticker)s"
    def Quote(/** defines quotes to download */ ticker = "^GSPC",
              /** defines first day to download in form YYYY-MM-DD */ start = "2001-1-1",
              /** defines last day to download in form YYYY-MM-DD */ end = "2010-1-1") : .IObservable[.Price]
    
    /** Observable listening to *source*
     *  When *source* changes it inserts *undefined* value and then immidiately becomes equal to *source* value
     */
    @python.intrinsic("observable.breaks_at_changes.BreaksAtChanges_Impl")
    def BreaksAtChanges(source = .const(1.0)) : .IObservable[.Float]
    
}

type ITrader

type IGraph

type Function[T] : IFunction[T]

type Volume = Int

type Optional[T]

type IAccount

type IOrder

type Side

type Boolean

type Price = Float

type IOrderQueue

type Float

type Int : Float

type ILink

type IOrderBook

type IEvent

type ILadderStrategy : ISuspendableStrategy

type IMultiAssetStrategy

type ITwoWayLink

type IObservable[U] : IFunction[U], IEvent

type IFunction[T] = () => T

type ISingleAssetStrategy

type ISingleAssetTrader : IAccount, ITrader

type IVolumeLevels

type ISuspendableStrategy : ISingleAssetStrategy

type List[T]

type Observable[U] : IObservable[U]

type IDifferentiable : IFunction[Float]

type ITimeSerie

type Any

type ICandleStick

type IOrderGenerator = IObservable[IOrder]

type String

/** Function always returning *x*
 */
@category = "Basic"
@label = "C=%(x)s"
def constant(x = 1.0) = .const(x) : .IFunction[.Float]

/** Function always returning *x*
 */
@category = "Basic"
@label = "C=%(x)s"
def constant(x = 1) = .const(x) : .IFunction[.Int]

/** Function always returning *False*
 */
@category = "Basic"
@label = "False"
def false() = .observableFalse() : .IFunction[.Boolean]

/** Trivial observable always returning *True*
 */
@category = "Basic"
@python.intrinsic.observable("_constant.True_Impl")
@label = "True"
def observableTrue() : .IObservable[.Boolean]

@category = "Basic"
@python.intrinsic("event.CurrentTime_Impl")
def CurrentTime() : .IObservable[.Float]

/** Trivial observable always returning *undefined* or *None* value
 */
@category = "Basic"
@python.intrinsic("_constant.Null_Impl")
def null() : () => .Float

/** Time serie to store and render it after on a graph
 *  Used to specify what data should be collected about order books and traders
 */
@category = "Basic"
@python.intrinsic("timeserie.ToRecord_Impl")
@label = "%(source)s"
def TimeSerie(source = .const(0.0) : .IObservable[.Any],
              graph = .veusz.Graph(),
              _digitsToShow = 4,
              _smooth = 1) : .ITimeSerie

/** Trivial observable always returning *False*
 */
@category = "Basic"
@python.intrinsic.observable("_constant.False_Impl")
@label = "False"
def observableFalse() : .IObservable[.Boolean]

/** Trivial observable always returning *x*
 */
@category = "Basic"
@python.intrinsic.observable("_constant.Constant_Impl")
@label = "C=%(x)s"
@trivialObservable = "true"
def const(x = 1.0) : .IObservable[.Float]

/** Trivial observable always returning *x*
 */
@category = "Basic"
@python.intrinsic.observable("_constant.Constant_Impl")
@label = "C=%(x)s"
@trivialObservable = "true"
def const(x = 1) : .IObservable[.Int]

/** Observable returning at the end of every *timeframe*
 * open/close/min/max price, its average and standard deviation
 */
@category = "Basic"
@python.intrinsic("observable.candlestick.CandleSticks_Impl")
@label = "Candles_{%(source)s}"
def CandleSticks(/** observable data source considered as asset price */ source = .const(1.0),
                 /** size of timeframe */ timeframe = 10.0) : .IObservable[.ICandleStick]

/** Function always returning *True*
 */
@category = "Basic"
@label = "True"
def true() = .observableTrue() : .IFunction[.Boolean]

/** Returns *x* if defined and *elsePart* otherwise
 */
@category = "Basic"
@python.observable()
@label = "If def(%(x)s) else %(elsePart)s"
@method = "getOrElse"
def IfDefined(x = .constant(1.0),
              /** function to take values from when *x* is undefined */ elsePart = .constant(1.0)) = if x<>.null() then x else elsePart

/** Time serie holding volume levels of an asset
 * Level of volume V is a price at which cumulative volume of better orders is V
 */
@category = "Basic"
@python.intrinsic("timeserie.VolumeLevels_Impl")
@label = "%(source)s"
def volumeLevels(source : .IFunction[.IVolumeLevels],
                 graph = .veusz.Graph(),
                 _digitsToShow = 4,
                 _smooth = 1,
                 _volumes = [30.0],
                 _isBuy = 1) : .ITimeSerie

