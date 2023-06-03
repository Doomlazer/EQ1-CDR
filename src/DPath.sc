;;; Sierra Script 1.0 - (do not remove this comment)
(script# 964)
(include sci.sh)
(use Cycle)
(use Obj)


(class DPath of Motion
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		points 0
		value 0
	)
	
	(method (init theClient theCaller &tmp temp0)
		(= points (if points else (List new:)))
		(if argc
			(= client theClient)
			(= temp0 0)
			(while (<= temp0 (- argc 3))
				(points add: [theCaller temp0] [theCaller (++ temp0)])
				(++ temp0)
			)
			(if (<= temp0 (- argc 2)) (= caller [theCaller temp0]))
		)
		(if (points contains: -32768) else (points add: -32768))
		(self setTarget:)
		(super init:)
		(if (not argc) (self doit:))
	)
	
	(method (dispose)
		(if (IsObject points) (points dispose:))
		(super dispose:)
	)
	
	(method (moveDone)
		(if (== (points at: value) -32768)
			(super moveDone:)
		else
			(self init:)
		)
	)
	
	(method (setTarget)
		(if (!= (points at: value) -32768)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
		)
	)
)
