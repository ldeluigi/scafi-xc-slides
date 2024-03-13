import Numeric.Implicits.*

object GradientLibrary:
  def distanceEstimate[N: Numeric: UpperBounded](
    using language: AggregateFoundation & DistanceSensor[N]
  )(neighboursEstimates: language.AggregateValue[N]): N = 
    lift(neighboursEstimates, senseDistance[N])(_ + _).withoutSelf.min
