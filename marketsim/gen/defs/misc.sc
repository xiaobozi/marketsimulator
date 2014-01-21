@category = "Basic"
package observable
{
    @python.intrinsic("observable.candlestick.CandleSticks_Impl")
    @label = "Candles_{%(source)s}"
    def CandleSticks(source = const(), timeframe = 10.0) : IObservable[CandleStick]
}

@category = "Basic"
package {
    @label = "C=%(x)s"
    def constant(x = 1.0) : IFunction[Float] = const(x)

    @python.intrinsic.function("_constant._Constant_Impl")
    @label = "C=%(x)s"
    def const(x = 1.0) : IObservable[Float]

    @python.intrinsic.function("_constant._True_Impl")
    @label = "True"
    def true() : IObservable[Boolean]

    @python.intrinsic.function("_constant._False_Impl")
    @label = "False"
    def false() : IObservable[Boolean]

    @python.intrinsic("_constant._Null_Impl")
    def null() => Float

    @python.observable
    @label = "If def(%(x)s) else %(elsePart)s"
    def IfDefined(x = constant(), elsePart = constant()) =
        if x <> null() then x else elsePart

    @python.intrinsic("timeserie._ToRecord_Impl")
    @label = "%(source)s"
    def TimeSerie(source        = const(0.) : IObservable[Any],
                  graph         = veusz.Graph(),
                  _digitsToShow = 4,
                  _smooth       = 1) : ITimeSerie

    @python.intrinsic("timeserie._VolumeLevels_Impl")
    @label = "%(source)s"
    def volumeLevels(source        : IFunction[IVolumeLevels],
                     graph         = veusz.Graph(),
                     _digitsToShow = 4,
                     _smooth       = 1,
                     _volumes      = [30.],
                     _isBuy        = 1)
        : ITimeSerie
}


@category = "N/A"
package veusz
{
    @python.intrinsic("veusz._Graph_Impl")
    def Graph(name = "graph") : IGraph
}


