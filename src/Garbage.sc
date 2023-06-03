;;; Sierra Script 1.0 - (do not remove this comment)
(script# 813)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Obj)


(class Garbage of EcoView
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		lookStr 0
		flag 0
	)
	
	(method (init)
		(super init: &rest)
		(self hide:)
		(if (not (self checkFlag:))
			(self show: approachVerbs: 6 4 2 ignoreActors: 1 stopUpd:)
			(if (or (not approachX) (not approachY))
				(if (< (self x?) 161)
					(self approachX: (+ x 33) approachY: (- y 7))
				else
					(self approachX: (- x 33) approachY: (- y 7))
				)
			)
			(if (not priority) (self setPri: 0))
		else
			(self dispose:)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(EcoNarrator init: 1 0 0 149 0 4)
			)
			(2
				(EcoNarrator init: 1 0 0 148 0 4)
			)
			(44
				(EcoNarrator init: 1 0 0 149 0 4)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (checkFlag)
		(return (& [global236 (/ flag 16)] (>> $8000 (mod flag 16))))
	)
	
	(method (setFlag)
		(= [global236 (/ flag 16)]
			(| [global236 (/ flag 16)] (>> $8000 (mod flag 16)))
		)
	)
	
	(method (cue)
		(self setFlag: dispose:)
		(Animate (gCast elements?) 0)
		(self checkRoom:)
	)
	
	(method (checkRoom)
		(if (not (gCast firstTrue: #isKindOf Garbage))
			(switch gNumber
				(120
					(if (not (proc819_5 344))
						(EcoNarrator init: global250 0 0 15)
					)
					(proc0_4 10 344)
				)
				(180
					(if (not (proc819_5 347))
						(EcoNarrator init: global250 0 0 96)
					)
					(proc0_4 10 347)
				)
				(200
					(if
					(or (not (proc819_5 345)) (not (proc819_5 346)))
						(EcoNarrator init: global250 0 0 96)
					)
					(if (proc819_5 345) (proc0_4 10 346))
					(proc0_4 10 345)
				)
				(420
					(if (not (proc819_5 348))
						(EcoNarrator init: global250 0 0 96)
					)
					(proc0_4 10 348)
				)
			)
		)
	)
)
